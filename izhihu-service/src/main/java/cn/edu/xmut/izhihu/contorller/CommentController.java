package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.request.CommentRequest;
import cn.edu.xmut.izhihu.pojo.request.DeleteCommentRequest;
import cn.edu.xmut.izhihu.service.CommnetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:32
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommnetService commnetService;

    @ApiOperation("列出文章的评论")
    @RequestMapping(value = "/listByArticle", method = RequestMethod.POST)
    public ResultVO listByArticle(@RequestParam String articleId) {
        return new SuccessVO(commnetService.find(articleId));
    }

    @ApiOperation("进行评论")
    @RequestMapping(value = "/remark", method = RequestMethod.POST)
    public ResultVO remark(@RequestBody CommentRequest record) {
        return commnetService.comment(record);
    }

    @ApiOperation("删除评论(只能删除自己的评论)")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultVO delete(@RequestBody DeleteCommentRequest record) {
        return commnetService.delete(record.getUserId(), record.getId());
    }
}
