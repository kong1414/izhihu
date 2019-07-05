package com.demo2.pojo.vo;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-29 20:47
 * @Version: 1.0
 */
@Data
public class UserVO {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 邮箱
     */
    private String email;

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
    private String photoUrl;

    /**
     * token
     */
    private String token;

    public UserVO() {
    }

    public UserVO(String userId, String email, String phone, String name, String photoUrl) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.photoUrl = photoUrl;
    }
}
