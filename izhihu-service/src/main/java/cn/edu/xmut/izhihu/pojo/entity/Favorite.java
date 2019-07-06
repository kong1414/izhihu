package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "favorite")
public class Favorite {
    /**
     * 收藏夹Id
     */
    @Id
    @Column(name = "favorite_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String favoriteId;

    /**
     * 收藏夹名称
     */
    @Column(name = "favorite_name")
    private String favoriteName;

    /**
     * 收藏夹描述
     */
    private String describes;

    /**
     * 创建者用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 公开（1是/0否）
     */
    @Column(name = "is_public")
    private Integer isPublic;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取收藏夹Id
     *
     * @return favorite_id - 收藏夹Id
     */
    public String getFavoriteId() {
        return favoriteId;
    }

    /**
     * 设置收藏夹Id
     *
     * @param favoriteId 收藏夹Id
     */
    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId == null ? null : favoriteId.trim();
    }

    /**
     * 获取收藏夹名称
     *
     * @return favorite_name - 收藏夹名称
     */
    public String getFavoriteName() {
        return favoriteName;
    }

    /**
     * 设置收藏夹名称
     *
     * @param favoriteName 收藏夹名称
     */
    public void setFavoriteName(String favoriteName) {
        this.favoriteName = favoriteName == null ? null : favoriteName.trim();
    }

    /**
     * 获取收藏夹描述
     *
     * @return describes - 收藏夹描述
     */
    public String getDescribes() {
        return describes;
    }

    /**
     * 设置收藏夹描述
     *
     * @param describes 收藏夹描述
     */
    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    /**
     * 获取创建者用户id
     *
     * @return user_id - 创建者用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置创建者用户id
     *
     * @param userId 创建者用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取公开（1是/0否）
     *
     * @return is_public - 公开（1是/0否）
     */
    public Integer getIsPublic() {
        return isPublic;
    }

    /**
     * 设置公开（1是/0否）
     *
     * @param isPublic 公开（1是/0否）
     */
    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
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