package cn.edu.xmut.izhihu.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "users")
public class Users {
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
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像url
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 是否已删除（1删除0未删除）
     */
    private Integer del;

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
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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