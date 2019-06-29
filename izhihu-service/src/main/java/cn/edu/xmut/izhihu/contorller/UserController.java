package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.bo.LoginResultBO;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.LoginRequest;
import cn.edu.xmut.izhihu.pojo.vo.UserVO;
import cn.edu.xmut.izhihu.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户类controller
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:23
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录请求")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVO login(LoginRequest loginRequest) {
        ResultVO result = null;
        LoginResultBO res = null;

        res = userService.login(loginRequest);
        if (res.isSuccess()) {
            result = new ResultVO<UserVO>(HttpCodeEnum.REQUEST_SUCCESS.getCode(), res.getUserVO(), "登陆成功");
        } else {
            result = new ResultVO<UserVO>(HttpCodeEnum.REQUEST_FAIL.getCode(), res.getUserVO(), "账户或密码错误");
        }
        return result;
    }
}
