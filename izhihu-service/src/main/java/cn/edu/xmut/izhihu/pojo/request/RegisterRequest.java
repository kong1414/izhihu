package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-03 23:34
 * @Version: 1.0
 */
@Data
public class RegisterRequest {
    private String name;
    private String account;
    private String type;
    private String password;
}
