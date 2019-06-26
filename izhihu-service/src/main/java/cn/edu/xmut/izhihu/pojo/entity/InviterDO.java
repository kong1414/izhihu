package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "inviter")
public class InviterDO {
    /**
     * 问题Id
     */
    @Id
    @Column(name = "ques_id")
    private String quesId;

    /**
     * 邀请人Id
     */
    @Id
    @Column(name = "inviter_id")
    private String inviterId;

    /**
     * 被邀请的人，Id
     */
    @Id
    @Column(name = "invitee_id")
    private String inviteeId;

    /**
     * 是否已读（0未读1已读）
     */
    @Column(name = "is_read")
    private Integer isRead;

    /**
     * 邀请时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取问题Id
     *
     * @return ques_id - 问题Id
     */
    public String getQuesId() {
        return quesId;
    }

    /**
     * 设置问题Id
     *
     * @param quesId 问题Id
     */
    public void setQuesId(String quesId) {
        this.quesId = quesId == null ? null : quesId.trim();
    }

    /**
     * 获取邀请人Id
     *
     * @return inviter_id - 邀请人Id
     */
    public String getInviterId() {
        return inviterId;
    }

    /**
     * 设置邀请人Id
     *
     * @param inviterId 邀请人Id
     */
    public void setInviterId(String inviterId) {
        this.inviterId = inviterId == null ? null : inviterId.trim();
    }

    /**
     * 获取被邀请的人，Id
     *
     * @return invitee_id - 被邀请的人，Id
     */
    public String getInviteeId() {
        return inviteeId;
    }

    /**
     * 设置被邀请的人，Id
     *
     * @param inviteeId 被邀请的人，Id
     */
    public void setInviteeId(String inviteeId) {
        this.inviteeId = inviteeId == null ? null : inviteeId.trim();
    }

    /**
     * 获取是否已读（0未读1已读）
     *
     * @return is_read - 是否已读（0未读1已读）
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 设置是否已读（0未读1已读）
     *
     * @param isRead 是否已读（0未读1已读）
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * 获取邀请时间
     *
     * @return create_time - 邀请时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置邀请时间
     *
     * @param createTime 邀请时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}