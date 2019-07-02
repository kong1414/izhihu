package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-02 09:40
 * @Version: 1.0
 */
@Data
public class QuestionRequest {
    /**
     * 提问人id
     */
    private String questionerId;
    /**
     * 问题名称
     */
    private String quesName;
    /**
     * 问题描述
     */
    private String quesDescribe;

    /**
     * 关联的话题
     */
    private List<String> TopicList;

    /**
     * 匿名（1是/0否）
     */
    private Integer anonymity = 0;

}
