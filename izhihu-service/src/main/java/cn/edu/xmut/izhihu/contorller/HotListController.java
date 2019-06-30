package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.service.HotListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-29 23:07
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/hostList")
public class HotListController {

    @Autowired
    private HotListService hotListService;

    /**
     * 列出热榜
     * 根据categoryType
     *
     * @param categoryType 类别（0全部1科学2数码3体育4时尚5影视）
     * @return
     */
    @ApiOperation("列出热榜")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultVO list(@RequestParam(defaultValue = "0") int categoryType) {
        return hotListService.list(categoryType);
    }
}
