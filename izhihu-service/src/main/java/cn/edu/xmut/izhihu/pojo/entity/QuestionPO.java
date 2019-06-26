package cn.edu.xmut.izhihu.pojo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "question")
public class QuestionPO {
    /**
     * 问题id
     */
    @Id
    @Column(name = "ques_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer quesId;

    /**
     * 提问人id
     */
    @Column(name = "questioner_id")
    private String questionerId;

    /**
     * 问题名称
     */
    @Column(name = "ques_name")
    private String quesName;

    /**
     * 图片url
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 回答次数
     */
    @Column(name = "answer_num")
    private Integer answerNum;

    /**
     * 关注次数
     */
    @Column(name = "attention_num")
    private Integer attentionNum;

    /**
     * 浏览次数
     */
    @Column(name = "browse_num")
    private Integer browseNum;

    /**
     * 匿名（1是/0否）
     */
    private Integer anonymity;

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
    private String del;

    /**
     * 问题描述
     */
    @Column(name = "ques_describe")
    private String quesDescribe;

}