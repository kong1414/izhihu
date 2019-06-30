package cn.edu.xmut.izhihu.pojo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
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
    @Column(name = "category_type")
    private Integer categoryType;

}