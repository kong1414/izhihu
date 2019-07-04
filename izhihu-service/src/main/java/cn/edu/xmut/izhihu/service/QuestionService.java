package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.AnswerRequest;
import cn.edu.xmut.izhihu.pojo.request.QuestionRequest;

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
}
