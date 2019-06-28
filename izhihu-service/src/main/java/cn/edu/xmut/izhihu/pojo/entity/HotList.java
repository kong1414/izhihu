package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "hot_list")
public class HotList {
    /**
     * 热榜id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

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
     * 热度
     */
    @Column(name = "hot_num")
    private Integer hotNum;

    /**
     * 类别（0全部1科学2数码3体育4时尚5影视）
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 获取热榜id
     *
     * @return id - 热榜id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置热榜id
     *
     * @param id 热榜id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取热度
     *
     * @return hot_num - 热度
     */
    public Integer getHotNum() {
        return hotNum;
    }

    /**
     * 设置热度
     *
     * @param hotNum 热度
     */
    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }

    /**
     * 获取类别（0全部1科学2数码3体育4时尚5影视）
     *
     * @return category_id - 类别（0全部1科学2数码3体育4时尚5影视）
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类别（0全部1科学2数码3体育4时尚5影视）
     *
     * @param categoryId 类别（0全部1科学2数码3体育4时尚5影视）
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}