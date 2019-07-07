package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.UsersInfoMapper;
import cn.edu.xmut.izhihu.dao.UsersMapper;
import cn.edu.xmut.izhihu.pojo.bo.LoginResultBO;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.UserDO;
import cn.edu.xmut.izhihu.pojo.entity.UsersInfo;
import cn.edu.xmut.izhihu.pojo.request.LoginRequest;
import cn.edu.xmut.izhihu.pojo.request.RegisterRequest;
import cn.edu.xmut.izhihu.pojo.request.UpdateUserInfoRequest;
import cn.edu.xmut.izhihu.pojo.vo.UserVO;
import cn.edu.xmut.izhihu.service.UserService;
import cn.edu.xmut.izhihu.util.Gloal;
import cn.edu.xmut.izhihu.util.JWTUtil;
import cn.edu.xmut.izhihu.util.MapBeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.system.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:29
 * @Version: 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper userMapper;

    @Autowired
    private UsersInfoMapper usersInfoMapper;

    /**
     * 登录
     *
     * @param loginRequest
     * @return
     */
    @Override
    public LoginResultBO login(LoginRequest loginRequest) {

        LoginResultBO result = new LoginResultBO();
        boolean isSuccess = false;


        Example example = new Example(UserDO.class);
        example.createCriteria()
                .orEqualTo("phone", loginRequest.getAccount())
                .orEqualTo("email", loginRequest.getAccount());

        UserDO user = userMapper.selectOneByExample(example);


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
    @Override
    public ResultVO<Object> logout(String userId, String token)
            throws IllegalArgumentException, NoSuchMethodException, SecurityException {
// 检查请求退出的用户是否存在或是否可执行退出操作
        // UserDO userDO = this.getById(id);
        UserDO userDO = userMapper.selectByPrimaryKey(userId);

        if (userDO == null) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "用户不存在，无法退出");
        } else if ((userDO.getToken() == null || "".equals(userDO.getToken()))
                || userDO.getTokenTakeEffectTime() == null
                || (userDO.getTokenAge() == null || userDO.getTokenAge() == 0)) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "用户已退出，请勿重复操作");
        }
        Map<String, Object> claims = JWTUtil.parserJavaWebToken(token);
        UserVO tokenUserVO = null;
        // 校验token是否被篡改，被篡改的token无法正确解析出tokenUserVO
        if (claims == null || !claims.containsKey(Gloal.TOKEN_USER_INFO_KEY)) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "请求处理失败");
        } else {
            Map<String, Object> tokenUserInfo = (LinkedHashMap<String, Object>) claims.get(Gloal.TOKEN_USER_INFO_KEY);
            try {
                tokenUserVO = MapBeanUtil.map2Bean(tokenUserInfo, UserVO.class);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                return new ResultVO(HttpCodeEnum.SYSTEM_ERROR.getCode(), null, "系统异常，请联系管理员");
            }
            if (tokenUserVO == null || tokenUserVO.getUserId() == null) {
                return new ResultVO(HttpCodeEnum.SYSTEM_ERROR.getCode(), null, "系统异常，请联系管理员");
            }
        }
        // 校验token携带的tokenUserVO与数据库用户信息是否一致
        UserDO userDOInDatabase = this.getByToken(token);
        if (userDOInDatabase == null || !userDOInDatabase.getUserId().equals(tokenUserVO.getUserId())) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "请求处理失败");
        }
        // 校验登出请求的用户id与tokenUserVO是否一致
        if (!userDOInDatabase.getUserId().equals(userDO.getUserId())) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "请求处理失败");
        }
        // 执行退出操作
        int count = userMapper.updateTokenDisabled(userId);
        if (count > 0) {
            return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, null);
        } else {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "请求处理失败");
        }
    }

    /**
     * 通过token值来查找用户
     *
     * @param token
     * @return
     */
    @Override
    public UserDO getByToken(String token) {
        Example example = new Example(UserDO.class);
        example.createCriteria().andEqualTo("token", token);
        UserDO userDO = userMapper.selectOneByExample(example);
        return userDO;
    }

    /**
     * 刷新token
     *
     * @param userId
     * @return
     */
    @Override
    public ResultVO<Object> refreshToken(String userId) {
        UserDO updateBean = new UserDO();
        updateBean.setUserId(userId);
        updateBean.setTokenTakeEffectTime(new Date());
        int count = userMapper.updateByPrimaryKeySelective(updateBean);
        if (count > 0) {
            return new ResultVO(HttpCodeEnum.REQUEST_SUCCESS.getCode(), null, "");
        } else {
            return new ResultVO(HttpCodeEnum.SYSTEM_ERROR.getCode(), null, "系统异常，请联系管理员");
        }
    }

    /**
     * 获取个人信息
     *
     * @param userId
     * @return
     */
    @Override
    public ResultVO getUserInfo(String userId) {
        Map<String, Object> res = userMapper.userInfo(userId);
        return new SuccessVO(res);
    }

    /**
     * 注册用户
     *
     * @param record
     * @return
     */
    @Override
    public synchronized ResultVO register(RegisterRequest record) {
        String id = IdUtil.randomUUID();

        UserDO userDO = new UserDO();
        userDO.setUserId(id);
        userDO.setName(record.getName());

        if ("email".equals(record.getType())) { // 邮箱注册
            userDO.setEmail(record.getAccount());
        } else if ("phone".equals(record.getType())) { // 手机注册
            userDO.setPhone(record.getAccount());
        }
        userDO.setPassword(record.getPassword());
        userMapper.insertSelective(userDO);

        UsersInfo usersInfo = new UsersInfo();
        usersInfo.setUserId(id);
        usersInfoMapper.insertSelective(usersInfo);

        return new SuccessVO();
    }

    /**
     * 更新个人用户
     *
     * @param record
     * @return
     */
    @Override
    public synchronized ResultVO updateUserInfo(UpdateUserInfoRequest record) {
        UsersInfo usersInfo = usersInfoMapper.selectByPrimaryKey(record.getUserId());

        usersInfo.setGender(record.getGender());

        usersInfo.setAutograph(record.getAutograph());
        usersInfo.setIntroduce(record.getIntroduce());
        usersInfo.setIndustry(record.getIndustry());
        usersInfo.setPersonalityUrl(record.getPersonalityUrl());
        usersInfo.setCompany(record.getCompany());
        usersInfo.setPosition(record.getPosition());
        usersInfo.setSchool(record.getSchool());
        usersInfo.setMajor(record.getMajor());
        usersInfoMapper.updateByPrimaryKeySelective(usersInfo);


        UserDO userDO = userMapper.selectByPrimaryKey(record.getUserId());
        userDO.setName(record.getName());
        userDO.setPhotoUrl(record.getPhotoUrl());
        userMapper.updateByPrimaryKeySelective(userDO);

        return new SuccessVO("更新成功");
    }

}
