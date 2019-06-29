package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.bo.LoginResultBO;
import cn.edu.xmut.izhihu.pojo.request.LoginRequest;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:28
 * @Version: 1.0
 */
public interface UserService {


    /**
     * 登录操作
     *
     * @param loginRequest
     * @return
     */
    LoginResultBO login(LoginRequest loginRequest);
}
