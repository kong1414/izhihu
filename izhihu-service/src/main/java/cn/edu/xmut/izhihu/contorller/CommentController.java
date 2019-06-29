package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:32
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @ApiOperation("发现页的热门专栏")
    @RequestMapping(value = "/hotColumn", method = RequestMethod.POST)
    public ResultVO hotColumn() {
        return null;
    }
}
