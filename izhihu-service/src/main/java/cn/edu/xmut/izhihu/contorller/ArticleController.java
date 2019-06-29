package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:03
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("首页的推荐内容")
    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public ResultVO recommend() {
        return null;
    }


    @ApiOperation("首页的关注内容")
    @RequestMapping(value = "/attention", method = RequestMethod.POST)
    public ResultVO attention(@RequestParam(required = true) String userId) {
        return null;
    }

    @ApiOperation("发现页的编辑推荐")
    @RequestMapping(value = "/editorRecommend", method = RequestMethod.POST)
    public ResultVO editorRecommend() {
        return null;
    }

    @ApiOperation("发现页的今日最热")
    @RequestMapping(value = "/todayHot", method = RequestMethod.POST)
    public ResultVO todayHot() {
        return null;
    }

    @ApiOperation("发现页的本月最热")
    @RequestMapping(value = "/monthHot", method = RequestMethod.POST)
    public ResultVO monthHot() {
        return null;
    }


    @ApiOperation("写回答，发文章，写想法(回答问题)")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultVO create() {
        return null;
    }

    @ApiOperation("删除 回答文章想法")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultVO delete(String id) {
        return null;
    }

    @ApiOperation("某用户的所有文章")
    @RequestMapping(value = "/listByUser", method = RequestMethod.POST)
    public ResultVO list(String userId) {
        return null;
    }

}
