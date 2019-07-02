package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "topic_content")
public class TopicContent {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 话题id
     */
    @Column(name = "topic_id")
    private String topicId;

    /**
     * 内容id
     */
    @Column(name = "content_id")
    private String contentId;

    /**
     * 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     */
    private Integer type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取话题id
     *
     * @return topic_id - 话题id
     */
    public String getTopicId() {
        return topicId;
    }

    /**
     * 设置话题id
     *
     * @param topicId 话题id
     */
    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }

    /**
     * 获取内容id
     *
     * @return content_id - 内容id
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * 设置内容id
     *
     * @param contentId 内容id
     */
    public void setContentId(String contentId) {
        this.contentId = contentId == null ? null : contentId.trim();
    }

    /**
     * 获取类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     *
     * @return type - 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     *
     * @param type 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     */
    public void setType(Integer type) {
        this.type = type;
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