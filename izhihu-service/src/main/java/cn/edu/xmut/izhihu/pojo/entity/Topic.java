package cn.edu.xmut.izhihu.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "topic")
public class Topic {
    /**
     * 话题id
     */
    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer topicId;

    /**
     * 话题名称
     */
    @Column(name = "topic_name")
    private String topicName;

    /**
     * 话题描述
     */
    @Column(name = "topic_desc")
    private String topicDesc;

    /**
     * 话题父id
     */
    @Column(name = "topic_father_id")
    private Integer topicFatherId;

    /**
     * 话题图片url
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取话题id
     *
     * @return topic_id - 话题id
     */
    public Integer getTopicId() {
        return topicId;
    }

    /**
     * 设置话题id
     *
     * @param topicId 话题id
     */
    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    /**
     * 获取话题名称
     *
     * @return topic_name - 话题名称
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * 设置话题名称
     *
     * @param topicName 话题名称
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
    }

    /**
     * 获取话题描述
     *
     * @return topic_desc - 话题描述
     */
    public String getTopicDesc() {
        return topicDesc;
    }

    /**
     * 设置话题描述
     *
     * @param topicDesc 话题描述
     */
    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc == null ? null : topicDesc.trim();
    }

    /**
     * 获取话题父id
     *
     * @return topic_father_id - 话题父id
     */
    public Integer getTopicFatherId() {
        return topicFatherId;
    }

    /**
     * 设置话题父id
     *
     * @param topicFatherId 话题父id
     */
    public void setTopicFatherId(Integer topicFatherId) {
        this.topicFatherId = topicFatherId;
    }

    /**
     * 获取话题图片url
     *
     * @return photo_url - 话题图片url
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * 设置话题图片url
     *
     * @param photoUrl 话题图片url
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
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
}