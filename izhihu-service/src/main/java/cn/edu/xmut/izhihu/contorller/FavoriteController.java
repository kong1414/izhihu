package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.CollectRequest;
import cn.edu.xmut.izhihu.pojo.request.CreateFavoriteRequest;
import cn.edu.xmut.izhihu.pojo.request.UpdateFavoriteRequest;
import cn.edu.xmut.izhihu.service.FavoriteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;


    @ApiOperation("发现页的热门收藏夹")
    @RequestMapping(value = "/hotFavorite", method = RequestMethod.POST)
    public ResultVO hotFavorite(@RequestParam(defaultValue = "5",required = false) int num) {

        return favoriteService.hotFavorite(num);
    }

    @ApiOperation("某用户的收藏夹")
    @RequestMapping(value = "/myFavorite", method = RequestMethod.POST)
    public ResultVO myFavorite(@RequestParam("userId") String userId) {
        return favoriteService.myFavorite(userId);
    }

    @ApiOperation("我的全部收藏夹概况（收藏夹页）")
    @RequestMapping(value = "/myFavoriteDetail", method = RequestMethod.POST)
    public ResultVO myFavoriteDetail(@RequestParam("userId") String userId) {
        return favoriteService.myFavoriteDetail(userId);
    }

    @ApiOperation("我关注的收藏夹（收藏夹页）")
    @RequestMapping(value = "/myAttFavorite", method = RequestMethod.POST)
    public ResultVO myAttFavorite(@RequestParam("userId") String userId) {
        return favoriteService.myAttFavorite(userId);
    }

    @ApiOperation("创建收藏夹")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultVO create(@RequestBody CreateFavoriteRequest record) {

        return favoriteService.create(record);
    }

    @ApiOperation("更新编辑收藏夹")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVO update(@RequestBody UpdateFavoriteRequest record) {

        return favoriteService.update(record);
    }

    @ApiOperation("删除收藏夹（有数据会提示报错）")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultVO delete(@RequestParam("record") String record) {

        return favoriteService.del(record);
    }

    @ApiOperation("把文章加入收藏夹")
    @PostMapping("/collect")
    public ResultVO collect(@RequestBody CollectRequest record) {

        return favoriteService.collect(record.getFavoritesId(), record.getArticleId());
    }

    @ApiOperation("把文章取消收藏")
    @RequestMapping(value = "/unCollect", method = RequestMethod.POST)
    public ResultVO unCollect(@RequestBody CollectRequest record) {
        return favoriteService.unCollect(record.getFavoritesId(), record.getArticleId());
    }

    @ApiOperation("收藏夹详情页的信息")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResultVO detail(@RequestParam String id) {
        return favoriteService.detail(id);
    }


}
