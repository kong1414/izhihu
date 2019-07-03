package cn.edu.xmut.izhihu.pojo.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-03 23:13
 * @Version: 1.0
 */
@Data
public class CommentVO {
    /**
     * 评论id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 评论对象的id（回答文章想法问题）
     */
    @Column(name = "comment_id")
    private String commentId;

    /**
     * 是否是评论别人的评论（1是0不是），如果是reply_id要填
     */
    @Column(name = "is_reply")
    private Integer isReply;

    /**
     * 回复评论对象的id
     */
    @Column(name = "reply_id")
    private Integer replyId;

    /**
     * 评论人id
     */
    @Column(name = "commentator_id")
    private String commentatorId;

    /**
     * 评论人name
     */
    private String name;

    /**
     * 评论内容
     */
    @Column(name = "comment_content")
    private String commentContent;

    /**
     * 赞次数
     */
    @Column(name = "praise_num")
    private Integer praiseNum;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
