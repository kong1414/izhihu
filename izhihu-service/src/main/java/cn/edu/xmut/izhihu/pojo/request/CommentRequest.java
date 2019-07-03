package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-03 23:19
 * @Version: 1.0
 */
@Data
public class CommentRequest {

    /**
     * 评论的对象id
     */
    private String commentId;

    /**
     * 是否是评论别人的评论（1是0不是），如果是reply_id要填
     */
    private Integer isReply;

    /**
     * 回复评论的id
     */
    private Integer replyId;

    /**
     * 评论人id
     */
    private String commentatorId;

    /**
     * 评论内容
     */
    private String commentContent;
}
