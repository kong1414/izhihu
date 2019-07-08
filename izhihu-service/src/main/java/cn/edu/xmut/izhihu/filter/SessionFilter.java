package cn.edu.xmut.izhihu.filter;

import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.entity.UserDO;
import cn.edu.xmut.izhihu.pojo.vo.UserVO;
import cn.edu.xmut.izhihu.service.UserService;
import cn.edu.xmut.izhihu.util.Gloal;
import cn.edu.xmut.izhihu.util.JWTUtil;
import cn.edu.xmut.izhihu.util.MapBeanUtil;
import cn.edu.xmut.izhihu.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: QiuGuanLin
 * @Description: 过滤器
 * @Date: 0:28 2019/6/26
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/api/*")
public class SessionFilter implements Filter {

    @Autowired
    private UserService userService;

    /**
     * 执行过滤操作
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // chain.doFilter(httpRequest, response);


        // System.out.println("执行过滤操作。。。");
        // 获取url
        String uri = httpRequest.getRequestURI();
        // System.out.println("uri:" + uri);
        String strContextPath = httpRequest.getContextPath();
        // System.out.println("strContextPath:" + strContextPath);
        String url = uri;
        // String url = uri.substring(strContextPath.length(), uri.indexOf(Gloal.URL_END_WITH));
        // System.out.println("url:" + url);


        // 判断如果是登录请求则不需要过滤
        if (url.endsWith("login")) {
            chain.doFilter(httpRequest, response);
            return;
        }
        // 判断如果是登录请求则不需要过滤
        if (url.endsWith("register")) {
            chain.doFilter(httpRequest, response);
            return;
        }

        // // 获取token
        String token = httpRequest.getHeader(Gloal.REQUEST_HEADER_TOKEN_KEY);
        // // 解析token
        Map<String, Object> claims = JWTUtil.parserJavaWebToken(token);

        UserVO tokenUserVO = null;

        // 无法解析或解析结果中不包含用户信息key，踢出用户
        if (claims == null || !claims.containsKey(Gloal.TOKEN_USER_INFO_KEY)) {
            ResponseUtil.writeResponse(httpRequest, httpResponse, HttpCodeEnum.NO_LOGIN);
            return;
        } else {// 解析token中携带的用户信息
            Map<String, Object> tokenUserInfo = (LinkedHashMap<String, Object>) claims.get(Gloal.TOKEN_USER_INFO_KEY);
            // tokenUserVO.setId((Integer) tokenUserInfo.get("id"));
            // tokenUserVO.setUsername((String) tokenUserInfo.get("username"));
            // tokenUserVO.setMobile((String) tokenUserInfo.get("mobile"));
            // tokenUserVO.setEmail((String) tokenUserInfo.get("email"));
            // tokenUserVO.setRemark((String) tokenUserInfo.get("remark"));
            // tokenUserVO.setLastLoginTime((Date) tokenUserInfo.get("lastLoginTime"));
            // tokenUserVO.setToken((String) tokenUserInfo.get("token"));
            // tokenUserVO.setPwErrorsCount((Integer) tokenUserInfo.get("pwErrorsCount"));

            try {
                tokenUserVO = MapBeanUtil.map2Bean(tokenUserInfo, UserVO.class);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                ResponseUtil.writeResponse(httpRequest, httpResponse, HttpCodeEnum.NO_LOGIN);
                return;
            }

            // 如果获取到的Id为空也抛出异常
            if (tokenUserVO.getUserId() == null || tokenUserVO.getUserId() == null) {
                ResponseUtil.writeResponse(httpRequest, httpResponse, HttpCodeEnum.NO_LOGIN);
                return;
            }
        }

        // 以token从数据库获取用户信息
        UserDO userDO = userService.getByToken(token);
        // 用户信息为空或token生效时间为空或token有效时长为空，踢出用户
        if (userDO == null || userDO.getTokenAge() == null || userDO.getTokenTakeEffectTime() == null
                || !userDO.getUserId().equals(tokenUserVO.getUserId())) {
            ResponseUtil.writeResponse(httpRequest, httpResponse, HttpCodeEnum.NO_LOGIN);
            return;
        } else if (userDO.getTokenAge() != -1) {
            // token有效时长不为-1，需要判断是否有效
            // Long current = new Date().getTime();
            Long current = System.currentTimeMillis();
            // 判断token的过期时间
            if (current < userDO.getTokenTakeEffectTime().getTime() || current > userDO.getTokenTakeEffectTime().getTime() + userDO.getTokenAge()) {
                ResponseUtil.writeResponse(httpRequest, httpResponse, HttpCodeEnum.NO_LOGIN);
                return;
            }
        }
        userService.refreshToken(userDO.getUserId()); // 刷新token
        chain.doFilter(httpRequest, response);


    }

    /**
     * 过滤器初始化
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        // System.out.println("过滤器初始化。。。");
    }

    /**
     * 过滤器销毁
     */
    @Override
    public void destroy() {
        // System.out.println("过滤器销毁。。。");
    }

}