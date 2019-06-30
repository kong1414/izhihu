package cn.edu.xmut.izhihu.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 测试controller
 * @Author: qiuguanlin
 * @Date: 2019-06-24 10:33
 * @Version: 1.0
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
