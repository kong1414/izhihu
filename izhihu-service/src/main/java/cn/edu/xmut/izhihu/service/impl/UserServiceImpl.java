package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.UsersInfoMapper;
import cn.edu.xmut.izhihu.dao.UsersMapper;
import cn.edu.xmut.izhihu.pojo.bo.LoginResultBO;
import cn.edu.xmut.izhihu.pojo.entity.UserDO;
import cn.edu.xmut.izhihu.pojo.request.LoginRequest;
import cn.edu.xmut.izhihu.pojo.vo.UserVO;
import cn.edu.xmut.izhihu.service.UserService;
import cn.edu.xmut.izhihu.util.Gloal;
import cn.edu.xmut.izhihu.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:29
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper userMapper;

    @Autowired
    private UsersInfoMapper usersInfoMapper;

    @Override
    public LoginResultBO login(LoginRequest loginRequest) {

        LoginResultBO result = new LoginResultBO();
        boolean isSuccess = false;

        UserDO user = userMapper.getUserDOByAccount(loginRequest.getAccount());
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
            UserVO userVO = new UserVO(
                    user.getUserId(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getName(),
                    user.getPhotoUrl());

            // 设置token
            UserVO usertoken = userVO;
            Map<String, Object> claims = new HashMap<String, Object>();

            usertoken.setToken("");
            // 将其token设为空，防止token太长存不进数据库

            claims.put(Gloal.TOKEN_USER_INFO_KEY, usertoken);
            String token = JWTUtil.createJavaWebToken(claims);
            userVO.setToken(token);
            result.setUserVO(userVO);

            // 更新数据库
            UserDO updateUser = new UserDO();
            updateUser.setUserId(user.getUserId());
            updateUser.setToken(token);
            updateUser.setTokenTakeEffectTime(new Date());
            updateUser.setTokenAge(Gloal.TOKEN_AGE);

            userMapper.updateByPrimaryKeySelective(updateUser);
        }
        return result;
    }
}
