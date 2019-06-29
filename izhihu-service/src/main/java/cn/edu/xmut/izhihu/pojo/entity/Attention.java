package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "attention")
public class Attention {
    /**
     * 关注表id
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
     * 关注内容id
     */
    @Column(name = "att_id")
    private Integer attId;

    /**
     * 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     */
    private Integer type;

    /**
     * 关注时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取关注表id
     *
     * @return id - 关注表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置关注表id
     *
     * @param id 关注表id
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
     * 获取关注内容id
     *
     * @return att_id - 关注内容id
     */
    public Integer getAttId() {
        return attId;
    }

    /**
     * 设置关注内容id
     *
     * @param attId 关注内容id
     */
    public void setAttId(Integer attId) {
        this.attId = attId;
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
     * 获取关注时间
     *
     * @return create_time - 关注时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置关注时间
     *
     * @param createTime 关注时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}