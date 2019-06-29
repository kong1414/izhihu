package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 关注点赞相关的controller
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:26
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ali/follow")
public class FollowController {

    @ApiOperation("关注")
    @RequestMapping(value = "/inFollow", method = RequestMethod.POST)
    public ResultVO infollow(String userId, String contentId) {
        return null;
    }

    @ApiOperation("取消关注")
    @RequestMapping(value = "/unFollow", method = RequestMethod.POST)
    public ResultVO unfollow(String userId, String contentId) {
        return null;
    }

    @ApiOperation("点赞")
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public ResultVO like(String userId, String contentId) {
        return null;
    }

    @ApiOperation("取消点赞")
    @RequestMapping(value = "/unLike", method = RequestMethod.POST)
    public ResultVO unLike(String userId, String contentId) {
        return null;
    }
}
