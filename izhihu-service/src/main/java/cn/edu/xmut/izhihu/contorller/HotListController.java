package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.dao.ArticleMapper;
import cn.edu.xmut.izhihu.dao.QuestionMapper;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.service.HotListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 列出热榜
     * 根据categoryType
     *
     * @param categoryType 类别（0全部1科学2数码3体育4时尚5影视）
     * @return
     */
    @ApiOperation("列出热榜")
    @PostMapping("/list")
    public ResultVO list(@RequestParam(defaultValue = "0") int categoryType) {
        return hotListService.list(categoryType);
    }

    @ApiOperation("低配版热榜")
    @PostMapping("/getHotList")
    public ResultVO getHotList() {

        return new SuccessVO(questionMapper.getHotList());
    }
}
