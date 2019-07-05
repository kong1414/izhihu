package com.demo2.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-29 20:46
 * @Version: 1.0
 */
@Data
public class LoginRequest {
    private String account;
    private String password;
    private String type;
}
