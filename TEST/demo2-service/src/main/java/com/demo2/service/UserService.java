package com.demo2.service;

import com.demo2.dao.UserMapper;
import com.demo2.pojo.bo.LoginResultBO;
import com.demo2.pojo.common.ResultVO;
import com.demo2.pojo.entity.User;
import com.demo2.pojo.request.LoginRequest;
import com.demo2.pojo.vo.UserVO;
import com.demo2.util.Gloal;
import com.demo2.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-05 12:21
 * @Version: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public LoginResultBO login(LoginRequest loginRequest) {

        LoginResultBO result = new LoginResultBO();
        boolean isSuccess = false;

        User user = userMapper.findByName(loginRequest.getAccount());

        if (user == null) {
            result.setSuccess(isSuccess);
            result.setMsg("用户不存在");
            return result;
        }

        // 验证密码
        isSuccess = user.getPassword().toUpperCase().equals(loginRequest.getPassword().toUpperCase());
        result.setSuccess(isSuccess);

        if (isSuccess) {
            result.setMsg("登陆成功");
            UserVO userVO = new UserVO();
            userVO.setId(user.getId());
            userVO.setUsername(user.getUsername());
            userVO.setType(user.getType());
            result.setUserVO(userVO);


            // UserVO userVO = new UserVO(
            //         user.getUserId(),
            //         user.getEmail(),
            //         user.getPhone(),
            //         user.getName(),
            //         user.getPhotoUrl());

            // // 设置token
            // UserVO usertoken = userVO;
            // Map<String, Object> claims = new HashMap<String, Object>();
            //
            // usertoken.setToken("");
            // // 将其token设为空，防止token太长存不进数据库
            //
            // claims.put(Gloal.TOKEN_USER_INFO_KEY, usertoken);
            // String token = JWTUtil.createJavaWebToken(claims);
            // userVO.setToken(token);
            // result.setUserVO(userVO);
            //
            // // 更新数据库
            // UserDO updateUser = new UserDO();
            // updateUser.setUserId(user.getUserId());
            // updateUser.setToken(token);
            // updateUser.setTokenTakeEffectTime(new Date());
            // updateUser.setTokenAge(Gloal.TOKEN_AGE);

            // userMapper.updateByPrimaryKeySelective(updateUser);
        }
        return result;
    }


}
