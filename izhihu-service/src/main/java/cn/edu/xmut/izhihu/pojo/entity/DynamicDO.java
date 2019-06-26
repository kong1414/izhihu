package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "dynamic")
public class DynamicDO {
    /**
     * 个人动态表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 动作（1发表文章2赞同3回答4收藏文章5收藏回答6关注问题）
     */
    @Column(name = "action_type")
    private String actionType;

    /**
     * 类型（1文章2回答3问题）
     */
    @Column(name = "content_type")
    private String contentType;

    /**
     * 内容的id（问题id或者文章id或者回答id）
     */
    @Column(name = "content_id")
    private Integer contentId;

    /**
     * 动态时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取个人动态表id
     *
     * @return id - 个人动态表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置个人动态表id
     *
     * @param id 个人动态表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取动作（1发表文章2赞同3回答4收藏文章5收藏回答6关注问题）
     *
     * @return action_type - 动作（1发表文章2赞同3回答4收藏文章5收藏回答6关注问题）
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * 设置动作（1发表文章2赞同3回答4收藏文章5收藏回答6关注问题）
     *
     * @param actionType 动作（1发表文章2赞同3回答4收藏文章5收藏回答6关注问题）
     */
    public void setActionType(String actionType) {
        this.actionType = actionType == null ? null : actionType.trim();
    }

    /**
     * 获取类型（1文章2回答3问题）
     *
     * @return content_type - 类型（1文章2回答3问题）
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * 设置类型（1文章2回答3问题）
     *
     * @param contentType 类型（1文章2回答3问题）
     */
    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    /**
     * 获取内容的id（问题id或者文章id或者回答id）
     *
     * @return content_id - 内容的id（问题id或者文章id或者回答id）
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * 设置内容的id（问题id或者文章id或者回答id）
     *
     * @param contentId 内容的id（问题id或者文章id或者回答id）
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取动态时间
     *
     * @return create_time - 动态时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置动态时间
     *
     * @param createTime 动态时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}