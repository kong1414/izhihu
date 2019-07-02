package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.AnswerRequest;
import cn.edu.xmut.izhihu.pojo.request.QuestionRequest;
import cn.edu.xmut.izhihu.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
