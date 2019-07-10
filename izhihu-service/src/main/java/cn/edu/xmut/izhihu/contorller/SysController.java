package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.dao.*;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-10 10:29
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/sys")
public class SysController {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private SysMapper sysMapper;

    @ApiOperation("文章")
    @PostMapping("/findArticle")
    public ResultVO findArticle(@RequestParam(defaultValue = "") String keyword) {
        List<Map<String,Object>> list =  sysMapper.findArticle(keyword);
        return new SuccessVO(list);
    }
    @ApiOperation("问题")
    @PostMapping("/findQues")
    public ResultVO findQues(@RequestParam(defaultValue = "")String keyword) {
        List<Map<String,Object>> list =  sysMapper.findQues(keyword);
        return new SuccessVO(list);
    }
    @ApiOperation("评论")
    @PostMapping("/findComment")
    public ResultVO findComment(@RequestParam(defaultValue = "")String keyword) {
        List<Map<String,Object>> list =  sysMapper.findComment(keyword);
        return new SuccessVO(list);
    }
    @ApiOperation("话题")
    @PostMapping("/findTopic")
    public ResultVO findTopic(@RequestParam(defaultValue = "")String keyword) {
        List<Map<String,Object>> list =  sysMapper.findTopic(keyword);
        return new SuccessVO(list);
    }
    @ApiOperation("收藏夹")
    @PostMapping("/findFar")
    public ResultVO findFar(@RequestParam(defaultValue = "")String keyword) {
        List<Map<String,Object>> list =  sysMapper.findFar(keyword);
        return new SuccessVO(list);
    }

}
