package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "private_message")
public class PrivateMessage {
    /**
     * 私信Id
     */
    @Id
    @Column(name = "priv_mess_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String privMessId;

    /**
     * 接收私信用户Id
     */
    @Column(name = "takeIn_user_id")
    private String takeinUserId;

    /**
     * 发送私信用户Id
     */
    @Column(name = "send_user_id")
    private String sendUserId;

    /**
     * 发送时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否已读（0未读1已读）
     */
    private Integer read;

    /**
     * 是否已删除（1删除0未删除）
     */
    private Integer del;

    /**
     * 私信内容
     */
    @Column(name = "priv_mess_content")
    private String privMessContent;

    /**
     * 获取私信Id
     *
     * @return priv_mess_id - 私信Id
     */
    public String getPrivMessId() {
        return privMessId;
    }

    /**
     * 设置私信Id
     *
     * @param privMessId 私信Id
     */
    public void setPrivMessId(String privMessId) {
        this.privMessId = privMessId == null ? null : privMessId.trim();
    }

    /**
     * 获取接收私信用户Id
     *
     * @return takeIn_user_id - 接收私信用户Id
     */
    public String getTakeinUserId() {
        return takeinUserId;
    }

    /**
     * 设置接收私信用户Id
     *
     * @param takeinUserId 接收私信用户Id
     */
    public void setTakeinUserId(String takeinUserId) {
        this.takeinUserId = takeinUserId == null ? null : takeinUserId.trim();
    }

    /**
     * 获取发送私信用户Id
     *
     * @return send_user_id - 发送私信用户Id
     */
    public String getSendUserId() {
        return sendUserId;
    }

    /**
     * 设置发送私信用户Id
     *
     * @param sendUserId 发送私信用户Id
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId == null ? null : sendUserId.trim();
    }

    /**
     * 获取发送时间
     *
     * @return create_time - 发送时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发送时间
     *
     * @param createTime 发送时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否已读（0未读1已读）
     *
     * @return read - 是否已读（0未读1已读）
     */
    public Integer getRead() {
        return read;
    }

    /**
     * 设置是否已读（0未读1已读）
     *
     * @param read 是否已读（0未读1已读）
     */
    public void setRead(Integer read) {
        this.read = read;
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

    /**
     * 获取私信内容
     *
     * @return priv_mess_content - 私信内容
     */
    public String getPrivMessContent() {
        return privMessContent;
    }

    /**
     * 设置私信内容
     *
     * @param privMessContent 私信内容
     */
    public void setPrivMessContent(String privMessContent) {
        this.privMessContent = privMessContent == null ? null : privMessContent.trim();
    }
}