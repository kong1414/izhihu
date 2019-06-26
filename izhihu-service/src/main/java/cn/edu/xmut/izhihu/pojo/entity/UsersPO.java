package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "users")
public class UsersPO {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String userId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别(1为男，0为女)
     */
    private Integer gender;

    /**
     * 头像url
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 一句话简介（干什么的）签名
     */
    private String autograph;

    /**
     * 个人简介
     */
    private String introduce;

    /**
     * 行业
     */
    @Column(name = "indu_id")
    private Integer induId;

    /**
     * 赞次数
     */
    @Column(name = "praise_num")
    private Integer praiseNum;

    /**
     * 感谢次数
     */
    @Column(name = "thank_num")
    private Integer thankNum;

    /**
     * 提问次数
     */
    @Column(name = "question_num")
    private Integer questionNum;

    /**
     * 回答次数
     */
    @Column(name = "answer_num")
    private Integer answerNum;

    /**
     * 收藏次数
     */
    @Column(name = "collect_num")
    private Integer collectNum;

    /**
     * 编辑次数
     */
    @Column(name = "edit_num")
    private Integer editNum;

    /**
     * 关注了几人(数量)
     */
    @Column(name = "attention_num")
    private Integer attentionNum;

    /**
     * 关注该用户的人(数量)
     */
    @Column(name = "follower_num")
    private Integer followerNum;

    /**
     * 关注话题个数(数量)
     */
    @Column(name = "concern_topic_num")
    private Integer concernTopicNum;

    /**
     * 个性网址
     */
    @Column(name = "personality_url")
    private String personalityUrl;

    /**
     * 公司（公司和职位显示的时候用· 隔开）
     */
    private String company;

    /**
     * 职位（公司和职位显示的时候用· 隔开）
     */
    private String position;

    /**
     * 学校（学校和专业方向显示的时候用· 隔开）
     */
    private String school;

    /**
     * 专业方向（学校和专业方向显示的时候用· 隔开）
     */
    private String major;

    /**
     * 禁用（1是，0否）
     */
    private Integer forbidden;

    /**
     * 禁用时间
     */
    @Column(name = "forbidden_time")
    private Date forbiddenTime;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 创建人
     */
    @Column(name = "user_create")
    private String userCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 更新人
     */
    @Column(name = "user_modified")
    private String userModified;

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
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取手机号
     *
     * @return tel - 手机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号
     *
     * @param tel 手机号
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取性别(1为男，0为女)
     *
     * @return gender - 性别(1为男，0为女)
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别(1为男，0为女)
     *
     * @param gender 性别(1为男，0为女)
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取头像url
     *
     * @return photo_url - 头像url
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * 设置头像url
     *
     * @param photoUrl 头像url
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    /**
     * 获取一句话简介（干什么的）签名
     *
     * @return autograph - 一句话简介（干什么的）签名
     */
    public String getAutograph() {
        return autograph;
    }

    /**
     * 设置一句话简介（干什么的）签名
     *
     * @param autograph 一句话简介（干什么的）签名
     */
    public void setAutograph(String autograph) {
        this.autograph = autograph == null ? null : autograph.trim();
    }

    /**
     * 获取个人简介
     *
     * @return introduce - 个人简介
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置个人简介
     *
     * @param introduce 个人简介
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 获取行业
     *
     * @return indu_id - 行业
     */
    public Integer getInduId() {
        return induId;
    }

    /**
     * 设置行业
     *
     * @param induId 行业
     */
    public void setInduId(Integer induId) {
        this.induId = induId;
    }

    /**
     * 获取赞次数
     *
     * @return praise_num - 赞次数
     */
    public Integer getPraiseNum() {
        return praiseNum;
    }

    /**
     * 设置赞次数
     *
     * @param praiseNum 赞次数
     */
    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    /**
     * 获取感谢次数
     *
     * @return thank_num - 感谢次数
     */
    public Integer getThankNum() {
        return thankNum;
    }

    /**
     * 设置感谢次数
     *
     * @param thankNum 感谢次数
     */
    public void setThankNum(Integer thankNum) {
        this.thankNum = thankNum;
    }

    /**
     * 获取提问次数
     *
     * @return question_num - 提问次数
     */
    public Integer getQuestionNum() {
        return questionNum;
    }

    /**
     * 设置提问次数
     *
     * @param questionNum 提问次数
     */
    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
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
     * 获取收藏次数
     *
     * @return collect_num - 收藏次数
     */
    public Integer getCollectNum() {
        return collectNum;
    }

    /**
     * 设置收藏次数
     *
     * @param collectNum 收藏次数
     */
    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    /**
     * 获取编辑次数
     *
     * @return edit_num - 编辑次数
     */
    public Integer getEditNum() {
        return editNum;
    }

    /**
     * 设置编辑次数
     *
     * @param editNum 编辑次数
     */
    public void setEditNum(Integer editNum) {
        this.editNum = editNum;
    }

    /**
     * 获取关注了几人(数量)
     *
     * @return attention_num - 关注了几人(数量)
     */
    public Integer getAttentionNum() {
        return attentionNum;
    }

    /**
     * 设置关注了几人(数量)
     *
     * @param attentionNum 关注了几人(数量)
     */
    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    /**
     * 获取关注该用户的人(数量)
     *
     * @return follower_num - 关注该用户的人(数量)
     */
    public Integer getFollowerNum() {
        return followerNum;
    }

    /**
     * 设置关注该用户的人(数量)
     *
     * @param followerNum 关注该用户的人(数量)
     */
    public void setFollowerNum(Integer followerNum) {
        this.followerNum = followerNum;
    }

    /**
     * 获取关注话题个数(数量)
     *
     * @return concern_topic_num - 关注话题个数(数量)
     */
    public Integer getConcernTopicNum() {
        return concernTopicNum;
    }

    /**
     * 设置关注话题个数(数量)
     *
     * @param concernTopicNum 关注话题个数(数量)
     */
    public void setConcernTopicNum(Integer concernTopicNum) {
        this.concernTopicNum = concernTopicNum;
    }

    /**
     * 获取个性网址
     *
     * @return personality_url - 个性网址
     */
    public String getPersonalityUrl() {
        return personalityUrl;
    }

    /**
     * 设置个性网址
     *
     * @param personalityUrl 个性网址
     */
    public void setPersonalityUrl(String personalityUrl) {
        this.personalityUrl = personalityUrl == null ? null : personalityUrl.trim();
    }

    /**
     * 获取公司（公司和职位显示的时候用· 隔开）
     *
     * @return company - 公司（公司和职位显示的时候用· 隔开）
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置公司（公司和职位显示的时候用· 隔开）
     *
     * @param company 公司（公司和职位显示的时候用· 隔开）
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 获取职位（公司和职位显示的时候用· 隔开）
     *
     * @return position - 职位（公司和职位显示的时候用· 隔开）
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位（公司和职位显示的时候用· 隔开）
     *
     * @param position 职位（公司和职位显示的时候用· 隔开）
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 获取学校（学校和专业方向显示的时候用· 隔开）
     *
     * @return school - 学校（学校和专业方向显示的时候用· 隔开）
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置学校（学校和专业方向显示的时候用· 隔开）
     *
     * @param school 学校（学校和专业方向显示的时候用· 隔开）
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * 获取专业方向（学校和专业方向显示的时候用· 隔开）
     *
     * @return major - 专业方向（学校和专业方向显示的时候用· 隔开）
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业方向（学校和专业方向显示的时候用· 隔开）
     *
     * @param major 专业方向（学校和专业方向显示的时候用· 隔开）
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * 获取禁用（1是，0否）
     *
     * @return forbidden - 禁用（1是，0否）
     */
    public Integer getForbidden() {
        return forbidden;
    }

    /**
     * 设置禁用（1是，0否）
     *
     * @param forbidden 禁用（1是，0否）
     */
    public void setForbidden(Integer forbidden) {
        this.forbidden = forbidden;
    }

    /**
     * 获取禁用时间
     *
     * @return forbidden_time - 禁用时间
     */
    public Date getForbiddenTime() {
        return forbiddenTime;
    }

    /**
     * 设置禁用时间
     *
     * @param forbiddenTime 禁用时间
     */
    public void setForbiddenTime(Date forbiddenTime) {
        this.forbiddenTime = forbiddenTime;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取创建人
     *
     * @return user_create - 创建人
     */
    public String getUserCreate() {
        return userCreate;
    }

    /**
     * 设置创建人
     *
     * @param userCreate 创建人
     */
    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate == null ? null : userCreate.trim();
    }

    /**
     * 获取更新时间
     *
     * @return gmt_modified - 更新时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置更新时间
     *
     * @param gmtModified 更新时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取更新人
     *
     * @return user_modified - 更新人
     */
    public String getUserModified() {
        return userModified;
    }

    /**
     * 设置更新人
     *
     * @param userModified 更新人
     */
    public void setUserModified(String userModified) {
        this.userModified = userModified == null ? null : userModified.trim();
    }
}