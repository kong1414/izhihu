package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-02 10:01
 * @Version: 1.0
 */
@Data
public class ArticleRequest {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 类型
     */
    private int type;

    /**
     * 匿名（1是/0否）
     */
    private Integer anonymity = 0;

    /**
     * title
     */
    private String title;

    /**
     * 回答内容
     */
    private String content;

    /**
     * 关联话题
     */
    private List<String> topicList;

}
