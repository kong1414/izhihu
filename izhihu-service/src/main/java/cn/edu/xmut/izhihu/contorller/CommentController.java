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

    @ApiOperation("列出文章的评论")
    @RequestMapping(value = "/listByArticle", method = RequestMethod.POST)
    public ResultVO listByArticle(String articleId) {
        return null;
    }

    @ApiOperation("列出问题的评论")
    @RequestMapping(value = "/listByQuestion", method = RequestMethod.POST)
    public ResultVO listByQuestion(String questionId) {
        return null;
    }

    @ApiOperation("进行评论")
    @RequestMapping(value = "/remark", method = RequestMethod.POST)
    public ResultVO remark() {
        return null;
    }

    @ApiOperation("删除评论(只能删除自己的评论)")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultVO delete(String userId, String commentId) {
        return null;
    }
}
