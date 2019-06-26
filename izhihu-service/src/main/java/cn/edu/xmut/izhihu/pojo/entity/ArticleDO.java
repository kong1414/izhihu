package cn.edu.xmut.izhihu.pojo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "article")
public class ArticleDO {
    /**
     * 回答文章想法id
     */
    @Id
    private Integer id;

    /**
     * 类别（1回答，2文章，3想法）
     */
    private Integer type;

    /**
     * 问题的id
     */
    @Column(name = "ques_id")
    private Integer quesId;

    /**
     * 标题
     */
    private String title;

    /**
     * 标题图url
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 作者id
     */
    @Column(name = "author_id")
    private String authorId;

    /**
     * 匿名（1是/0否）
     */
    private Integer anonymity;

    /**
     * 评论次数
     */
    @Column(name = "comment_num")
    private Integer commentNum;

    /**
     * 举报次数
     */
    @Column(name = "report_num")
    private Integer reportNum;

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
     * 内容
     */
    private String content;

    /**
     * 获取回答文章想法id
     *
     * @return id - 回答文章想法id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置回答文章想法id
     *
     * @param id 回答文章想法id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类别（1回答，2文章，3想法）
     *
     * @return type - 类别（1回答，2文章，3想法）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类别（1回答，2文章，3想法）
     *
     * @param type 类别（1回答，2文章，3想法）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取问题的id
     *
     * @return ques_id - 问题的id
     */
    public Integer getQuesId() {
        return quesId;
    }

    /**
     * 设置问题的id
     *
     * @param quesId 问题的id
     */
    public void setQuesId(Integer quesId) {
        this.quesId = quesId;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取标题图url
     *
     * @return photo_url - 标题图url
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * 设置标题图url
     *
     * @param photoUrl 标题图url
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    /**
     * 获取作者id
     *
     * @return author_id - 作者id
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * 设置作者id
     *
     * @param authorId 作者id
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    /**
     * 获取匿名（1是/0否）
     *
     * @return anonymity - 匿名（1是/0否）
     */
    public Integer getAnonymity() {
        return anonymity;
    }

    /**
     * 设置匿名（1是/0否）
     *
     * @param anonymity 匿名（1是/0否）
     */
    public void setAnonymity(Integer anonymity) {
        this.anonymity = anonymity;
    }

    /**
     * 获取评论次数
     *
     * @return comment_num - 评论次数
     */
    public Integer getCommentNum() {
        return commentNum;
    }

    /**
     * 设置评论次数
     *
     * @param commentNum 评论次数
     */
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    /**
     * 获取举报次数
     *
     * @return report_num - 举报次数
     */
    public Integer getReportNum() {
        return reportNum;
    }

    /**
     * 设置举报次数
     *
     * @param reportNum 举报次数
     */
    public void setReportNum(Integer reportNum) {
        this.reportNum = reportNum;
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

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}