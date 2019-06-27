package cn.edu.xmut.izhihu.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
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
}