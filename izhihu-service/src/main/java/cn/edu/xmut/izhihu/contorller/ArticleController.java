package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.vo.ResultVO;
import cn.edu.xmut.izhihu.pojo.vo.SuccessVO;
import cn.edu.xmut.izhihu.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 回答文章想法类Controller
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:26
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(name = "/list",method = RequestMethod.POST)
    public ResultVO getList(){
        return new SuccessVO();
    }

    @ApiOperation("关注列表的文章展示")
    @RequestMapping(name = "/attentionList",method = RequestMethod.POST)
    public ResultVO getAttentionList(){
        return new SuccessVO();
    }

    @ApiOperation("推荐列表的文章展示")
    @RequestMapping(name = "/recommendList",method = RequestMethod.POST)
    public ResultVO getRecommendList(){
        return new SuccessVO();
    }

}
