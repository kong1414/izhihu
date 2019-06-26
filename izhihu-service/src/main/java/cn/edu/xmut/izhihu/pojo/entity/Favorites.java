package cn.edu.xmut.izhihu.pojo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "favorites")
public class Favorites {
    /**
     * 收藏夹Id
     */
    @Id
    @Column(name = "favorites_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer favoritesId;

    /**
     * 收藏夹名称
     */
    @Column(name = "favorites_name")
    private String favoritesName;

    /**
     * 收藏夹描述
     */
    private String describe;

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
     * @return favorites_id - 收藏夹Id
     */
    public Integer getFavoritesId() {
        return favoritesId;
    }

    /**
     * 设置收藏夹Id
     *
     * @param favoritesId 收藏夹Id
     */
    public void setFavoritesId(Integer favoritesId) {
        this.favoritesId = favoritesId;
    }

    /**
     * 获取收藏夹名称
     *
     * @return favorites_name - 收藏夹名称
     */
    public String getFavoritesName() {
        return favoritesName;
    }

    /**
     * 设置收藏夹名称
     *
     * @param favoritesName 收藏夹名称
     */
    public void setFavoritesName(String favoritesName) {
        this.favoritesName = favoritesName == null ? null : favoritesName.trim();
    }

    /**
     * 获取收藏夹描述
     *
     * @return describe - 收藏夹描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置收藏夹描述
     *
     * @param describe 收藏夹描述
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
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