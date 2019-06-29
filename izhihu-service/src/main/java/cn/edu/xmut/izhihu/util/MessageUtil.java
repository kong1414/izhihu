package cn.edu.xmut.izhihu.util;


import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author: QiuGuanLin
 * @Description: 获取国际化资源工具类
 * @Date: 9:06 2018/10/24
 */
public class MessageUtil {

    /**
     * 获取国际化配置文件中的信息
     *
     * @param request
     * @param key
     * @return
     */
    public static String getMessage(HttpServletRequest request, HttpCodeEnum key) {
        Locale currentLocale = RequestContextUtils.getLocale(request);
        String lang = currentLocale.getLanguage();
        ResourceBundle bundle = ResourceBundle.getBundle(Gloal.MESSAGE_PRE + lang, currentLocale);
        return bundle.getString(key.name());
    }
}
