package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.dao.*;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.*;
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
    @ApiOperation("删除文章")
    @PostMapping("/delArticle")
    public ResultVO delArticle(@RequestParam String id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        article.setDel(1);
        articleMapper.updateByPrimaryKey(article);
        return new SuccessVO("删除成功");
    }
    @ApiOperation("删除问题")
    @PostMapping("/delQues")
    public ResultVO delQues(@RequestParam String id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        question.setDel(1);
        questionMapper.updateByPrimaryKey(question);
        return new SuccessVO("删除成功");
    }
    @ApiOperation("删除评论")
    @PostMapping("/delComment")
    public ResultVO delComment(@RequestParam String id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        comment.setDel(1);
        commentMapper.updateByPrimaryKey(comment);
        return new SuccessVO("删除成功");
    }
    @ApiOperation("删除话题")
    @PostMapping("/delTopic")
    public ResultVO delTopic(@RequestParam String id) {
        topicMapper.deleteByPrimaryKey(id);
        return new SuccessVO("删除成功");
    }

}
