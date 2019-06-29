package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "question")
public class Question {
    /**
     * 问题id
     */
    @Id
    @Column(name = "ques_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String quesId;

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
    private Integer del;

    /**
     * 问题描述
     */
    @Column(name = "ques_describe")
    private String quesDescribe;

    /**
     * 获取问题id
     *
     * @return ques_id - 问题id
     */
    public String getQuesId() {
        return quesId;
    }

    /**
     * 设置问题id
     *
     * @param quesId 问题id
     */
    public void setQuesId(String quesId) {
        this.quesId = quesId == null ? null : quesId.trim();
    }

    /**
     * 获取提问人id
     *
     * @return questioner_id - 提问人id
     */
    public String getQuestionerId() {
        return questionerId;
    }

    /**
     * 设置提问人id
     *
     * @param questionerId 提问人id
     */
    public void setQuestionerId(String questionerId) {
        this.questionerId = questionerId == null ? null : questionerId.trim();
    }

    /**
     * 获取问题名称
     *
     * @return ques_name - 问题名称
     */
    public String getQuesName() {
        return quesName;
    }

    /**
     * 设置问题名称
     *
     * @param quesName 问题名称
     */
    public void setQuesName(String quesName) {
        this.quesName = quesName == null ? null : quesName.trim();
    }

    /**
     * 获取图片url
     *
     * @return photo_url - 图片url
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * 设置图片url
     *
     * @param photoUrl 图片url
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    /**
     * 获取回答次数
     *
     * @return answer_num - 回答次数
     */
    public Integer getAnswerNum() {
        return answerNum;
    }

    /**
     * 设置回答次数
     *
     * @param answerNum 回答次数
     */
    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    /**
     * 获取关注次数
     *
     * @return attention_num - 关注次数
     */
    public Integer getAttentionNum() {
        return attentionNum;
    }

    /**
     * 设置关注次数
     *
     * @param attentionNum 关注次数
     */
    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    /**
     * 获取浏览次数
     *
     * @return browse_num - 浏览次数
     */
    public Integer getBrowseNum() {
        return browseNum;
    }

    /**
     * 设置浏览次数
     *
     * @param browseNum 浏览次数
     */
    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    /**
     * 获取匿名（1是/0否）
     *
     * @return anonymity - 匿名（1是/0否）
     */
    public Integer getAnonymity() {
        return anonymity;
    }

    /**
     * 设置匿名（1是/0否）
     *
     * @param anonymity 匿名（1是/0否）
     */
    public void setAnonymity(Integer anonymity) {
        this.anonymity = anonymity;
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

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否已删除（1删除0未删除）
     *
     * @return del - 是否已删除（1删除0未删除）
     */
    public Integer getDel() {
        return del;
    }

    /**
     * 设置是否已删除（1删除0未删除）
     *
     * @param del 是否已删除（1删除0未删除）
     */
    public void setDel(Integer del) {
        this.del = del;
    }

    /**
     * 获取问题描述
     *
     * @return ques_describe - 问题描述
     */
    public String getQuesDescribe() {
        return quesDescribe;
    }

    /**
     * 设置问题描述
     *
     * @param quesDescribe 问题描述
     */
    public void setQuesDescribe(String quesDescribe) {
        this.quesDescribe = quesDescribe == null ? null : quesDescribe.trim();
    }
}