package cn.edu.xmut.izhihu.util;

import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: QiuGuanLin
 * @Description: response读写工具类
 * @Date: 9:05 2018/10/24
 */
public class ResponseUtil {

    /**
     * response输出信息
     *
     * @param request
     * @param response
     * @param code
     * @throws IOException
     */
    public static void writeResponse(HttpServletRequest request, HttpServletResponse response, HttpCodeEnum code) throws IOException {
        // 设置HTTP头部 application/json
        response.setContentType(Gloal.JONS_CONTENT_TYPE);
        // 设置UTF-8编码
        response.setCharacterEncoding(Gloal.ENCODING);
        // 向前端返回错误数据
        // response.getWriter().print(JsonMapper.toJson(new ResultVO<String>(code.getCode(), null, MessageUtil.getMessage(request, code))));
        response.getWriter().print(JsonMapper.toJson(new ResultVO<String>(code.getCode(), null, "未登录")));
    }
}
