package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @ApiOperation("发现页的热门收藏夹")
    @RequestMapping(value = "/hotFavorite", method = RequestMethod.POST)
    public ResultVO hotFavorite() {
        return null;
    }

    @ApiOperation("某用户的收藏夹")
    @RequestMapping(value = "/myFavorite", method = RequestMethod.POST)
    public ResultVO myFavorite() {
        return null;
    }

    @ApiOperation("创建收藏夹")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultVO create() {
        return null;
    }

    @ApiOperation("更新收藏夹")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVO update() {
        return null;
    }

    @ApiOperation("删除收藏夹（会删除收藏夹内数据）")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultVO delete() {
        return null;
    }

    @ApiOperation("把文章加入收藏夹")
    @RequestMapping(value = "/collect", method = RequestMethod.POST)
    public ResultVO collect() {
        return null;
    }

    @ApiOperation("把文章取消收藏")
    @RequestMapping(value = "/unCollect", method = RequestMethod.POST)
    public ResultVO unCollect() {
        return null;
    }
}
