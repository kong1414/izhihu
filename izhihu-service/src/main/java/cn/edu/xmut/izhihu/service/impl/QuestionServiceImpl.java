package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.ArticleMapper;
import cn.edu.xmut.izhihu.dao.QuestionMapper;
import cn.edu.xmut.izhihu.dao.TopicContentMapper;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.common.Type;
import cn.edu.xmut.izhihu.pojo.entity.Article;
import cn.edu.xmut.izhihu.pojo.entity.Question;
import cn.edu.xmut.izhihu.pojo.entity.TopicContent;
import cn.edu.xmut.izhihu.pojo.request.AnswerRequest;
import cn.edu.xmut.izhihu.pojo.request.QuestionRequest;
import cn.edu.xmut.izhihu.service.QuestionService;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TopicContentMapper topicContentMapper;

    /**
     * 创建一个问题
     *
     * @param record
     * @return
     */
    @Override
    public synchronized ResultVO create(QuestionRequest record) {
        Question ques = new Question();
        String id = IdUtil.randomUUID();
        ques.setQuesId(id);
        ques.setQuestionerId(record.getQuestionerId());
        ques.setQuesName(record.getQuesName());
        ques.setQuesDescribe(record.getQuesDescribe());
        ques.setAnonymity(record.getAnonymity());
        questionMapper.insertSelective(ques);

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
            tc.setType(Type.QUESTION.getCode());
            topicContentMapper.insert(tc);
        }
        return new SuccessVO(id, "");
    }

    /**
     * 回答问题
     *
     * @param record
     * @return
     */
    @Override
    public synchronized ResultVO answer(AnswerRequest record) {
        Question question = questionMapper.selectByPrimaryKey(record.getQuesId());

        Article article = new Article();

        article.setArticleId(IdUtil.randomUUID());
        article.setAnonymity(record.getAnonymity());
        article.setType(Type.ANSWER.getCode());
        article.setAuthorId(record.getUserId());
        article.setQuesId(record.getQuesId());
        article.setTitle(question.getQuesName());

        articleMapper.insertSelective(article);

        return new SuccessVO();
    }

    /**
     * 根据问题id返回问题信息
     *
     * @param quesId
     * @return
     */
    @Override
    public synchronized ResultVO findById(String quesId) {
        Question question = questionMapper.selectByPrimaryKey(quesId);
        if (question == null) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "问题id错误");
        }
        question.setBrowseNum(question.getBrowseNum() + 1);
        questionMapper.updateByPrimaryKey(question);
        return new SuccessVO(question);
    }

    /**
     * 根据问题id
     * 获取问题下的所有回答
     *
     * @param quesId
     * @return
     */
    @Override
    public ResultVO findAnsByQues(String quesId) {

        List<Map<String, Object>> res = questionMapper.findAnsByQues(quesId);
        return new SuccessVO(res);
    }

    /**
     * 发现页编辑推荐 问题
     *
     * @return
     */
    @Override
    public ResultVO editorRecommend() {
        List<Map<String, Object>> list = questionMapper.getQuesRandom();

        return new SuccessVO(list);
    }


}
