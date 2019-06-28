package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users_info")
public class UsersInfo {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String userId;

    /**
     * 性别(1为男2为女0未知)
     */
    private Integer gender;

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
    private String industry;

    /**
     * 个性网址
     */
    @Column(name = "personality_url")
    private String personalityUrl;

    /**
     * 公司
     */
    private String company;

    /**
     * 职位
     */
    private String position;

    /**
     * 学校
     */
    private String school;

    /**
     * 专业方向
     */
    private String major;

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
     * 获取性别(1为男2为女0未知)
     *
     * @return gender - 性别(1为男2为女0未知)
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别(1为男2为女0未知)
     *
     * @param gender 性别(1为男2为女0未知)
     */
    public void setGender(Integer gender) {
        this.gender = gender;
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
     * @return industry - 行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置行业
     *
     * @param industry 行业
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
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
     * 获取公司
     *
     * @return company - 公司
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置公司
     *
     * @param company 公司
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * 获取职位
     *
     * @return position - 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 获取学校
     *
     * @return school - 学校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置学校
     *
     * @param school 学校
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * 获取专业方向
     *
     * @return major - 专业方向
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业方向
     *
     * @param major 专业方向
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }
}