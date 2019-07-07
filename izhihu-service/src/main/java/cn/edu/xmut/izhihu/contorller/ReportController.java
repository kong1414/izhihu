package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.ReportRequest;
import cn.edu.xmut.izhihu.service.ReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 举报相关
 * @Author: qiuguanlin
 * @Date: 2019-07-07 16:06
 * @Version: 1.0
 */
@ApiOperation("举报相关")
@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @ApiOperation("进行举报")
    @PostMapping("/report")
    public ResultVO report(@RequestBody ReportRequest record) {
        return null;
    }

}
