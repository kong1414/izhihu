package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.dao.AgreeOpposeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 测试controller
 * @Author: qiuguanlin
 * @Date: 2019-06-24 10:33
 * @Version: 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private AgreeOpposeMapper agreeOpposeMapper;

    @RequestMapping("/helloworld")
    public String helloworld() {
        agreeOpposeMapper.selectAll();
        return "helloworld";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
