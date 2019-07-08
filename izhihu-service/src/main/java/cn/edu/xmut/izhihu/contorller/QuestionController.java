package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.AnswerRequest;
import cn.edu.xmut.izhihu.pojo.request.QuestionRequest;
import cn.edu.xmut.izhihu.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 问题Controller
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:26
 * @Version: 1.0
 */
// @Api("问题的controller")
@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation("创建问题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultVO createQuestion(@RequestBody QuestionRequest record) {
        return questionService.create(record);
    }

    @ApiOperation("回答问题")
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public ResultVO answerQuestion(@RequestBody AnswerRequest record) {
        return questionService.answer(record);
    }

    /**
     * 查询问题详情
     *
     * @param quesId
     * @return
     */
    @ApiOperation("查询问题id")
    @PostMapping("/findById")
    public ResultVO findById(@RequestParam String quesId) {
        return questionService.findById(quesId);
    }

    @ApiOperation("获取问题下的所有回答")
    @PostMapping("/findAnsByQues")
    public ResultVO findAnsByQues(@RequestParam String quesId) {
        return questionService.findAnsByQues(quesId);
    }

    @ApiOperation("获取问题下关联的话题")
    @PostMapping("/findTopicByQues")
    public ResultVO findTopicByQues(@RequestParam String quesId) {
        return questionService.findTopicByQues(quesId);
    }

    @ApiOperation("根据用户id 获取用户的提问")
    @PostMapping("/findQuesByUser")
    public ResultVO findQuesByUser(@RequestParam String userId) {
        return questionService.findQuesByUser(userId);
    }

}
