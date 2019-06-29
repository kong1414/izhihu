package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "report")
public class Report {
    /**
     * 举报id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 举报类型
     */
    @Column(name = "report_type")
    private String reportType;

    /**
     * 举报人
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     */
    private Integer type;

    /**
     * 内容id
     */
    @Column(name = "content_id")
    private String contentId;

    /**
     * 举报内容
     */
    @Column(name = "report_content")
    private String reportContent;

    /**
     * 处理状态（0未处理1已处理2忽略）
     */
    private Integer status;

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
     * 更新人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 获取举报id
     *
     * @return id - 举报id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置举报id
     *
     * @param id 举报id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取举报类型
     *
     * @return report_type - 举报类型
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * 设置举报类型
     *
     * @param reportType 举报类型
     */
    public void setReportType(String reportType) {
        this.reportType = reportType == null ? null : reportType.trim();
    }

    /**
     * 获取举报人
     *
     * @return user_id - 举报人
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置举报人
     *
     * @param userId 举报人
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * 获取举报内容
     *
     * @return report_content - 举报内容
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * 设置举报内容
     *
     * @param reportContent 举报内容
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
    }

    /**
     * 获取处理状态（0未处理1已处理2忽略）
     *
     * @return status - 处理状态（0未处理1已处理2忽略）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置处理状态（0未处理1已处理2忽略）
     *
     * @param status 处理状态（0未处理1已处理2忽略）
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取更新人
     *
     * @return update_user - 更新人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新人
     *
     * @param updateUser 更新人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}