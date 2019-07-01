package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.vo.HotTopicVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 话题 controller
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:36
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/topic")
public class TopicController {

    @ApiOperation("发现页的热门话题")
    @RequestMapping(value = "/hotTopic", method = RequestMethod.POST)
    public ResultVO hotTopic() {
        //TODO：假数据

        List<HotTopicVO> list = new ArrayList<>();
        HotTopicVO a = new HotTopicVO();
        a.setTopicId("12314124124");
        a.setTopicName("美食");
        a.setPhotoUrl("http://b-ssl.duitang.com/uploads/item/201510/08/20151008192345_uPC5U.jpeg");
        a.setAttNum(200);
        list.add(a);
        list.add(a);
        list.add(a);

        return new SuccessVO(list);
    }

    @ApiOperation("新增话题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultVO create() {
        return null;
    }

    @ApiOperation("编辑话题")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVO update() {
        return null;
    }

    @ApiOperation("删除话题(有子话题时不可删)")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultVO delete() {
        return null;
    }

    @ApiOperation("删除话题(有子话题时可删，强制删除)")
    @RequestMapping(value = "/forceDelete", method = RequestMethod.POST)
    public ResultVO forceDelete(String id) {
        return null;
    }

    @ApiOperation("关联话题（父子关系）")
    @RequestMapping(value = "/relevance", method = RequestMethod.POST)
    public ResultVO relevance(String id, String id2) {
        return null;
    }

    @ApiOperation("已关注话题")
    @RequestMapping(value = "/attedTopic", method = RequestMethod.POST)
    public ResultVO attedTopic(String userId) {
        return null;
    }

    @ApiOperation("某话题下的热门文章")
    @RequestMapping(value = "/topicArticle", method = RequestMethod.POST)
    public ResultVO topicArticle(String topicId) {
        return null;
    }

    @ApiOperation("随机10个话题（话题页其他人关注的话题）")
    @RequestMapping(value = "/topicRandom", method = RequestMethod.POST)
    public ResultVO topicArticle(@RequestParam(defaultValue = "10") int num) {
        return null;
    }
}
