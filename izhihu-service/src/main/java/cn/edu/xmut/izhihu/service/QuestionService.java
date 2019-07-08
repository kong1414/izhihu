package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.AnswerRequest;
import cn.edu.xmut.izhihu.pojo.request.QuestionRequest;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:41
 * @Version: 1.0
 */
public interface QuestionService {
    /**
     * 创建一个问题
     *
     * @param record
     * @return
     */
    ResultVO create(QuestionRequest record);

    /**
     * 回答问题
     *
     * @param record
     * @return
     */
    ResultVO answer(AnswerRequest record);

    /**
     * 根据问题id返回问题信息
     *
     * @param quesId
     * @return
     */
    ResultVO findById(String quesId);

    /**
     * 根据问题id
     * 获取问题下的所有回答
     *
     * @param quesId
     * @return
     */
    ResultVO findAnsByQues(String quesId);

    /**
     * 发现页编辑推荐 问题
     *
     * @return
     */
    ResultVO editorRecommend();

    /**
     * 获取问题的关联话题
     *
     * @param quesId
     * @return
     */
    ResultVO findTopicByQues(String quesId);

    /**
     * 根据用户id 获取用户的提问
     *
     * @param UserId
     * @return
     */
    ResultVO findQuesByUser(String UserId);
}
