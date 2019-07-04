package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.ArticleMapper;
import cn.edu.xmut.izhihu.dao.TopicContentMapper;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.Article;
import cn.edu.xmut.izhihu.pojo.entity.TopicContent;
import cn.edu.xmut.izhihu.pojo.request.ArticleRequest;
import cn.edu.xmut.izhihu.service.ArticleService;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


}
