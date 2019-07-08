package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.service.FollowService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description: 关注点赞相关的controller
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:26
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @ApiOperation("关注")
    @RequestMapping(value = "/inFollow", method = RequestMethod.POST)
    public ResultVO infollow(@RequestBody Map<String, String> record) {

        return followService.infollow(
                record.get("userId"),
                record.get("contentId"),
                Integer.parseInt(record.get("type")));
    }

    @ApiOperation("取消关注")
    @RequestMapping(value = "/unFollow", method = RequestMethod.POST)
    public ResultVO unfollow(@RequestBody Map<String, String> record) {
        return followService.unfollow(record.get("userId"), record.get("contentId"));
    }

    @ApiOperation("点赞")
    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public ResultVO like(@RequestBody Map<String, String> record) {
        return followService.like(record.get("userId"), record.get("contentId"));
    }

    @ApiOperation("不赞同")
    @RequestMapping(value = "/unLike", method = RequestMethod.POST)
    public ResultVO unLike(@RequestBody Map<String, String> record) {
        return followService.unlike(record.get("userId"), record.get("contentId"));
    }

    @ApiOperation("取消态度（取消点赞和不赞同）")
    @RequestMapping(value = "/cancelLike", method = RequestMethod.POST)
    public ResultVO cancelLike(@RequestBody Map<String, String> record) {
        return followService.cancelLike(record.get("userId"), record.get("contentId"));
    }
}
