package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-02 09:52
 * @Version: 1.0
 */
@Data
public class AnswerRequest {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 问题的id
     */
    private String quesId;

    /**
     * 匿名（1是/0否）
     */
    private Integer anonymity = 0;

    /**
     * 回答内容
     */
    private String content;
}
