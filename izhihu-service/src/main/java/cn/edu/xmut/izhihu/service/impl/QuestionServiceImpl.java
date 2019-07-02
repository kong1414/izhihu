package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.ArticleMapper;
import cn.edu.xmut.izhihu.dao.QuestionMapper;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.common.Type;
import cn.edu.xmut.izhihu.pojo.entity.Article;
import cn.edu.xmut.izhihu.pojo.entity.Question;
import cn.edu.xmut.izhihu.pojo.request.AnswerRequest;
import cn.edu.xmut.izhihu.pojo.request.QuestionRequest;
import cn.edu.xmut.izhihu.service.QuestionService;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 创建一个问题
     *
     * @param record
     * @return
     */
    @Override
    public synchronized ResultVO create(QuestionRequest record) {
        Question ques = new Question();
        ques.setQuesId(IdUtil.randomUUID());
        ques.setQuestionerId(record.getQuestionerId());
        ques.setQuesName(record.getQuesName());
        ques.setQuesDescribe(record.getQuesDescribe());
        ques.setAnonymity(record.getAnonymity());
        questionMapper.insert(ques);
        return new SuccessVO();
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

        articleMapper.insert(article);

        return new SuccessVO();
    }


}
