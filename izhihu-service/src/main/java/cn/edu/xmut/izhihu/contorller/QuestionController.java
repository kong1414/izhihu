package cn.edu.xmut.izhihu.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
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

    // @ApiOperation("创建问题")
    // @RequestMapping(name = "/create", method = RequestMethod.POST)
    // public ResultVO createQuestion(@RequestBody @Valid QuestionRequest record) {
    //
    //     return new SuccessVO();
    // }
}
