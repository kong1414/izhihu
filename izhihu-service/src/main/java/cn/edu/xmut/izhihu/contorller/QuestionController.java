package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @ApiOperation("创建问题")
    @RequestMapping(name = "/create", method = RequestMethod.POST)
    public ResultVO createQuestion(@RequestBody @Valid QuestionRequest record) {

        return new SuccessVO(record);
    }
}
