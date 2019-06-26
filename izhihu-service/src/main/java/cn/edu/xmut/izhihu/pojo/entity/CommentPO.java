package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "comment")
public class CommentPO {
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
    private Integer commentId;

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
    private Integer commentatorId;

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

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否已删除（1删除0未删除）
     */
    private Integer del;

    /**
     * 获取评论id
     *
     * @return id - 评论id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置评论id
     *
     * @param id 评论id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取评论对象的id（回答文章想法问题）
     *
     * @return comment_id - 评论对象的id（回答文章想法问题）
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 设置评论对象的id（回答文章想法问题）
     *
     * @param commentId 评论对象的id（回答文章想法问题）
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取是否是评论别人的评论（1是0不是），如果是reply_id要填
     *
     * @return is_reply - 是否是评论别人的评论（1是0不是），如果是reply_id要填
     */
    public Integer getIsReply() {
        return isReply;
    }

    /**
     * 设置是否是评论别人的评论（1是0不是），如果是reply_id要填
     *
     * @param isReply 是否是评论别人的评论（1是0不是），如果是reply_id要填
     */
    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }

    /**
     * 获取回复评论对象的id
     *
     * @return reply_id - 回复评论对象的id
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * 设置回复评论对象的id
     *
     * @param replyId 回复评论对象的id
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    /**
     * 获取评论人id
     *
     * @return commentator_id - 评论人id
     */
    public Integer getCommentatorId() {
        return commentatorId;
    }

    /**
     * 设置评论人id
     *
     * @param commentatorId 评论人id
     */
    public void setCommentatorId(Integer commentatorId) {
        this.commentatorId = commentatorId;
    }

    /**
     * 获取评论内容
     *
     * @return comment_content - 评论内容
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置评论内容
     *
     * @param commentContent 评论内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    /**
     * 获取赞次数
     *
     * @return praise_num - 赞次数
     */
    public Integer getPraiseNum() {
        return praiseNum;
    }

    /**
     * 设置赞次数
     *
     * @param praiseNum 赞次数
     */
    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否已删除（1删除0未删除）
     *
     * @return del - 是否已删除（1删除0未删除）
     */
    public Integer getDel() {
        return del;
    }

    /**
     * 设置是否已删除（1删除0未删除）
     *
     * @param del 是否已删除（1删除0未删除）
     */
    public void setDel(Integer del) {
        this.del = del;
    }
}