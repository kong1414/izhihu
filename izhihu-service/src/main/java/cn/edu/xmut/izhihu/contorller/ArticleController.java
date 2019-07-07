package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.ArtTypeRequest;
import cn.edu.xmut.izhihu.pojo.request.ArticleRequest;
import cn.edu.xmut.izhihu.service.ArticleService;
import cn.edu.xmut.izhihu.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @Autowired
    private QuestionService questionService;

    @ApiOperation("首页的推荐内容")
    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public ResultVO recommend() {

        return articleService.recommend();
    }

    @ApiOperation("首页的关注内容 （！需要前端去重以及根据时间排序）")
    @RequestMapping(value = "/attContetn", method = RequestMethod.POST)
    public ResultVO attContetn(@RequestParam String userId) {
        return articleService.attContetn(userId);
    }

    @ApiOperation("发现页的编辑推荐")
    @RequestMapping(value = "/editorRecommend", method = RequestMethod.POST)
    public ResultVO editorRecommend() {

        return questionService.editorRecommend();
    }

    @ApiOperation("发现页的今日最热")
    @RequestMapping(value = "/todayHot", method = RequestMethod.POST)
    public ResultVO todayHot() {
        return articleService.todayHot();
    }

    @ApiOperation("发现页的本月最热")
    @RequestMapping(value = "/monthHot", method = RequestMethod.POST)
    public ResultVO monthHot() {
        return articleService.monthHot();
    }

    @ApiOperation("发文章，写想法")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultVO create(@RequestBody ArticleRequest record) {
        return articleService.create(record);
    }

    @ApiOperation("删除 回答文章想法")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultVO delete(@RequestBody Map<String, String> map) {
        return articleService.delete(map.get("userId"), map.get("articleId"));
    }

    @ApiOperation("某用户的所有文章")
    @RequestMapping(value = "/listByUser", method = RequestMethod.POST)
    public ResultVO list(@RequestBody ArtTypeRequest record) {
        return articleService.getArticleByUser(record.getUserId(), record.getType());
    }

}
