package cn.edu.xmut.izhihu.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
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
    private String attId;

    /**
     * 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     */
    private Integer type;

    /**
     * 关注时间
     */
    @Column(name = "create_time")
    private Date createTime;
}