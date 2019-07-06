package cn.edu.xmut.izhihu.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "favorite_article")
public class FavoriteArticle {
    /**
     * 收藏文章关联表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 收藏夹Id
     */
    @Column(name = "favorites_id")
    private String favoritesId;

    /**
     * 文章Id
     */
    @Column(name = "article_id")
    private String articleId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取收藏文章关联表
     *
     * @return id - 收藏文章关联表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置收藏文章关联表
     *
     * @param id 收藏文章关联表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取收藏夹Id
     *
     * @return favorites_id - 收藏夹Id
     */
    public String getFavoritesId() {
        return favoritesId;
    }

    /**
     * 设置收藏夹Id
     *
     * @param favoritesId 收藏夹Id
     */
    public void setFavoritesId(String favoritesId) {
        this.favoritesId = favoritesId == null ? null : favoritesId.trim();
    }

    /**
     * 获取文章Id
     *
     * @return article_id - 文章Id
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * 设置文章Id
     *
     * @param articleId 文章Id
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
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