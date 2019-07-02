package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.Topic;
import cn.edu.xmut.izhihu.pojo.vo.HotTopicVO;
import cn.edu.xmut.izhihu.service.TopicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private TopicService topicService;


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
    public ResultVO create(@RequestBody Topic topic) {
        return topicService.create(topic);
    }

    @ApiOperation("编辑话题")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultVO update(@RequestBody Topic record) {
        return topicService.update(record);
    }

    @ApiOperation("删除话题(有子话题时不可删)")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultVO delete(@RequestParam(required = true) String topicId) {
        return topicService.delete(topicId);
    }

    @ApiOperation("删除话题(有子话题时可删，强制删除)")
    @RequestMapping(value = "/forceDelete", method = RequestMethod.POST)
    public ResultVO forceDelete(@RequestParam(required = true) String topicId) {
        return topicService.forceDelete(topicId);
    }

    @ApiOperation("话题关联话题（父子关系）第一个参数子id，第二个参数父id")
    @RequestMapping(value = "/relevance", method = RequestMethod.POST)
    public ResultVO relevance(@RequestParam(required = true) String id,
                              @RequestParam(required = true) String fId) {
        topicService.relevanceTopic(id, fId);
        return new SuccessVO();
    }

    @ApiOperation("已关注话题")
    @RequestMapping(value = "/attedTopic", method = RequestMethod.POST)
    public ResultVO attedTopic(@RequestParam(required = true) String userId) {
        return new SuccessVO(topicService.getAttedTopic(userId));
    }

    @ApiOperation("某话题下的热门文章")
    @RequestMapping(value = "/topicArticle", method = RequestMethod.POST)
    public ResultVO topicArticle(@RequestParam(required = true) String topicId) {
        return new SuccessVO(topicService.getTopicArticle(topicId));
    }

    @ApiOperation("随机5个话题（话题页其他人关注的话题）")
    @RequestMapping(value = "/topicRandom", method = RequestMethod.POST)
    public ResultVO topicRandom(@RequestParam(defaultValue = "5") int num) {
        return new SuccessVO(topicService.getTopicRandom(5));
    }

    @ApiOperation("查看话题详情")
    @RequestMapping(value = "/topicDetial", method = RequestMethod.POST)
    public ResultVO topicDetial(@RequestParam(required = true) String topicId) {
        return new SuccessVO(topicService.getTopicOne(topicId));
    }

    @ApiOperation("获取话题的父话题")
    @RequestMapping(value = "/topicFather", method = RequestMethod.POST)
    public ResultVO topicFather(@RequestParam(required = true) String topicId) {
        return new SuccessVO(topicService.getTopicFather(topicId));
    }

    @ApiOperation("获取话题的子话题列表")
    @RequestMapping(value = "/topicChild", method = RequestMethod.POST)
    public ResultVO topicChild(@RequestParam(required = true) String topicId) {
        return new SuccessVO(topicService.getTopicChild(topicId));
    }

    @ApiOperation("模糊搜索话题")
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public ResultVO find(@RequestParam(defaultValue = "") String keyword) {
        return new SuccessVO(topicService.find(keyword));
    }
}
