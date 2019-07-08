package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.ArticleMapper;
import cn.edu.xmut.izhihu.dao.AttentionMapper;
import cn.edu.xmut.izhihu.dao.TopicContentMapper;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.common.Type;
import cn.edu.xmut.izhihu.pojo.entity.Article;
import cn.edu.xmut.izhihu.pojo.entity.Attention;
import cn.edu.xmut.izhihu.pojo.entity.TopicContent;
import cn.edu.xmut.izhihu.pojo.request.ArticleRequest;
import cn.edu.xmut.izhihu.service.ArticleService;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:04
 * @Version: 1.0
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TopicContentMapper topicContentMapper;

    @Autowired
    private AttentionMapper attentionMapper;

    /**
     * 创建文章想法
     *
     * @param record
     * @return
     */
    @Override
    public synchronized ResultVO create(ArticleRequest record) {

        Article article = new Article();
        String id = IdUtil.randomUUID();
        article.setArticleId(id);
        article.setTitle(record.getTitle());
        article.setAuthorId(record.getUserId());
        article.setContent(record.getContent());
        article.setType(record.getType());
        article.setAnonymity(record.getAnonymity());
        articleMapper.insertSelective(article);
        if (record.getTopicList().size() <= 0) {
            return new SuccessVO();
        }
        List<String> topicList = record.getTopicList();
        for (int i = 0; i < topicList.size(); i++) {
            //内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            String topicId = topicList.get(i);
            TopicContent tc = new TopicContent();
            tc.setTopicId(topicId);
            tc.setContentId(id);
            tc.setType(record.getType());
            topicContentMapper.insert(tc);
        }

        return new SuccessVO("发布成功");
    }

    /**
     * 首页推荐文章
     *
     * @return
     */
    @Override
    public ResultVO recommend() {

        List<Map<String, Object>> list = articleMapper.getArticleRandom();

        return new SuccessVO(list);
    }

    /**
     * 今日最热
     *
     * @return
     */
    @Override
    public ResultVO todayHot() {
        List<Map<String, Object>> list = articleMapper.todayHot();

        return new SuccessVO(list);
    }

    /**
     * 本月最热
     *
     * @return
     */
    @Override
    public ResultVO monthHot() {
        List<Map<String, Object>> list = articleMapper.monthHot();
        return new SuccessVO(list);
    }

    /**
     * 获取用户的所有文章信息
     *
     * @param userId
     * @param type   类别（1回答，2文章，3想法）
     *               类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     * @return
     */
    @Override
    public ResultVO getArticleByUser(String userId, int type) {

        if (type == 0) {
            List<Map<String, Object>> res =
                    articleMapper.getArticleByUserId(userId);
            return new SuccessVO(res);
        }

        List<Map<String, Object>> list =
                articleMapper.getArticleByUser(userId, type);

        return new SuccessVO(list);
    }

    /**
     * 首页的关注内容
     *
     * @param userId
     * @return
     */
    @Override
    public ResultVO attContetn(String userId) {
        List<Map<String, Object>> res = new ArrayList();

        // 1获取关注的问题的最新回答
        // 1.1获取关注的问题id
        Example example = new Example(Attention.class);
        example.createCriteria()
                .andEqualTo("userId", userId)
                .andEqualTo("type", Type.QUESTION.getCode());
        List<Attention> list = attentionMapper.selectByExample(example);

        // 1.2根据问题id获得article
        for (Attention i : list) {
            List<Map<String, Object>> record = articleMapper.getArticleByQues(i.getAttId());
            res.addAll(record);
        }

        // 2获取关注的用户的最新回答
        // 2.1获取关注的用户id
        Example example2 = new Example(Attention.class);
        example.createCriteria()
                .andEqualTo("userId", userId)
                .andEqualTo("type", Type.USER.getCode());
        List<Attention> list2 = attentionMapper.selectByExample(example2);

        // 2.2获取用户的回答
        for (Attention i : list2) {
            List<Map<String, Object>> record = articleMapper.getArticleByUserId(i.getAttId());
            res.addAll(record);
        }

        // 3 去重排序（最后决定前端去重）

        return new SuccessVO(res);
    }

    /**
     * 删除文章
     *
     * @param userId
     * @param artiId
     * @return
     */
    @Override
    public ResultVO delete(String userId, String artiId) {

        Article record = articleMapper.selectByPrimaryKey(artiId);
        if (userId.equals(record.getAuthorId())) {
            record.setDel(1);
            articleMapper.updateByPrimaryKeySelective(record);
            return new SuccessVO("删除成功");
        } else {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "不能删除别人的文章哦");
        }
    }


}
