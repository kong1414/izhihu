package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.bo.LoginResultBO;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.entity.UserDO;
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

    /**
     * 用户登出操作
     *
     * @param userId
     * @param token
     * @return
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     */
    ResultVO<Object> logout(String userId, String token) throws IllegalArgumentException, NoSuchMethodException, SecurityException;

    /**
     * 通过token值来查找用户
     *
     * @param token
     * @return
     */
    public UserDO getByToken(String token);

    /**
     * 刷新token
     *
     * @param userId
     * @return
     */
    ResultVO<Object> refreshToken(String userId);
}
