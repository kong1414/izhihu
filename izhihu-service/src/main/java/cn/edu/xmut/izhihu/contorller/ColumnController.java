package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.entity.ColumnDO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 00:10
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/column")
public class ColumnController {


    /**
     * 热门圆桌改热门专栏
     *
     * @return
     */
    @ApiOperation("发现页的热门专栏")
    @RequestMapping(value = "/hotColumn", method = RequestMethod.POST)
    public ResultVO hotColumn() {
        return null;
    }

    /**
     * 创建专栏
     *
     * @param record
     * @return
     */
    @RequestMapping("/create")
    public ResultVO create(@RequestBody ColumnDO record) {
        return null;
    }

    /**
     * 获得专栏下的文章
     *
     * @param record
     * @return
     */
    @RequestMapping("/getColumnCrticle")
    public ResultVO getColumnCrticle(@RequestBody ColumnDO record) {
        return null;
    }
}
