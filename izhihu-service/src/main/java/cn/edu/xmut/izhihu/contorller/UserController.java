package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.bo.LoginResultBO;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.request.LoginRequest;
import cn.edu.xmut.izhihu.pojo.request.RegisterRequest;
import cn.edu.xmut.izhihu.pojo.request.UpdateFavoriteRequest;
import cn.edu.xmut.izhihu.pojo.request.UpdateUserInfoRequest;
import cn.edu.xmut.izhihu.pojo.vo.UserVO;
import cn.edu.xmut.izhihu.service.UserService;
import cn.edu.xmut.izhihu.util.Gloal;
import cn.edu.xmut.izhihu.util.OSSClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private OSSClientUtil ossClientUtil;

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

    /**
     * 登出
     *
     * @param userId
     * @param req
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResultVO<Object> logout(@RequestParam String userId, HttpServletRequest req) {
        ResultVO<Object> result = null;
        try {
            result = userService.logout(userId, req.getHeader(Gloal.REQUEST_HEADER_TOKEN_KEY));
        } catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
            return new ResultVO<Object>(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "");
        }
        return result;
    }


    /**
     * 获得个人信息个人主页
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResultVO people(@RequestParam String userId) {
        return userService.getUserInfo(userId);
    }

    /**
     * 注册
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultVO register(@RequestBody RegisterRequest record) {
        return userService.register(record);
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadImage")
    public ResultVO uploadImage(@RequestParam("file") MultipartFile file) {
        String imageUrl = ossClientUtil.checkImage(file);
        return new SuccessVO(imageUrl, "");
    }

    @ApiOperation("更新个人信息")
    @PostMapping("/updateUserInfo")
    public ResultVO updateUserInfo(@RequestBody UpdateUserInfoRequest record) {
        return userService.updateUserInfo(record);
    }

}
