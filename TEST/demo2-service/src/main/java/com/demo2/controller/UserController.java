package com.demo2.controller;

import com.demo2.dao.UserMapper;
import com.demo2.pojo.bo.LoginResultBO;
import com.demo2.pojo.common.HttpCodeEnum;
import com.demo2.pojo.common.ResultVO;
import com.demo2.pojo.request.LoginRequest;
import com.demo2.pojo.vo.UserVO;
import com.demo2.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-05 12:20
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @ApiOperation("登录请求")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVO login(@RequestBody LoginRequest loginRequest) {
        ResultVO result = null;
        LoginResultBO res = null;

        res = userService.login(loginRequest);
        if (res.isSuccess()) {
            result = new ResultVO<UserVO>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), res.getUserVO(), "登陆成功");
        } else {
            result = new ResultVO<UserVO>(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "账户或密码错误");
        }
        return result;
    }

}
