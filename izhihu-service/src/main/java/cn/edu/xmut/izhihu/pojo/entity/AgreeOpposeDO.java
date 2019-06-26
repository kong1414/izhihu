package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "agree_oppose")
public class AgreeOpposeDO {
    /**
     * 赞同反对表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 用户Id(哪个用户赞同、回答)
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 哪个回答文章想法问题Id(用户对哪个回答文章想法问题反对/赞同)
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 1赞同/0反对
     */
    @Column(name = "agr_opp")
    private Integer agrOpp;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取赞同反对表id
     *
     * @return id - 赞同反对表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置赞同反对表id
     *
     * @param id 赞同反对表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户Id(哪个用户赞同、回答)
     *
     * @return user_id - 用户Id(哪个用户赞同、回答)
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户Id(哪个用户赞同、回答)
     *
     * @param userId 用户Id(哪个用户赞同、回答)
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取哪个回答文章想法问题Id(用户对哪个回答文章想法问题反对/赞同)
     *
     * @return article_id - 哪个回答文章想法问题Id(用户对哪个回答文章想法问题反对/赞同)
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置哪个回答文章想法问题Id(用户对哪个回答文章想法问题反对/赞同)
     *
     * @param articleId 哪个回答文章想法问题Id(用户对哪个回答文章想法问题反对/赞同)
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取1赞同/0反对
     *
     * @return agr_opp - 1赞同/0反对
     */
    public Integer getAgrOpp() {
        return agrOpp;
    }

    /**
     * 设置1赞同/0反对
     *
     * @param agrOpp 1赞同/0反对
     */
    public void setAgrOpp(Integer agrOpp) {
        this.agrOpp = agrOpp;
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