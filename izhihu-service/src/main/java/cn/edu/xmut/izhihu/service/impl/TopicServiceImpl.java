package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.TopicMapper;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.Topic;
import cn.edu.xmut.izhihu.service.TopicService;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-01 15:30
 * @Version: 1.0
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    /**
     * 随机获取num个话题
     *
     * @param num
     * @return
     */
    @Override
    public List<Topic> getTopicRandom(int num) {
        return topicMapper.getTopicRandom(num);
    }

    /**
     * 获取某个Topic下的热门文章
     *
     * @param topicId
     * @return
     */
    @Override
    public List<Map<String, Object>> getTopicArticle(String topicId) {
        return topicMapper.getTopicArticle(topicId);
    }

    /**
     * 获取已关注的话题
     *
     * @param userId
     * @return
     */
    @Override
    public List<Topic> getAttedTopic(String userId) {
        return topicMapper.getAttedTopic(userId);
    }

    /**
     * 关联话题，把话题关联起来（后台的）
     *
     * @param id  子id
     * @param fId 父id
     */
    @Override
    public synchronized void relevanceTopic(String id, String fId) {
        Topic topic = topicMapper.selectByPrimaryKey(id);
        topic.setTopicFatherId(fId);
        topicMapper.updateByPrimaryKeySelective(topic);
        return;
    }

    /**
     * 删除话题有关联话题时无法删除
     *
     * @param topicId
     */
    @Override
    public synchronized ResultVO delete(String topicId) {
        Topic record = new Topic();
        record.setTopicFatherId(topicId);

        List<Topic> list = topicMapper.select(record);
        if (list.size() > 0) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "存在关联话题无法删除");
        } else {
            topicMapper.deleteByPrimaryKey(topicId);
            return new SuccessVO();

        }
    }

    /**
     * 删除话题 有关联话题会连级删除
     *
     * @param topicId
     */
    @Override
    public ResultVO forceDelete(String topicId) {

        topicMapper.deleteByPrimaryKey(topicId);
        return new SuccessVO();
    }

    /**
     * 更新topic
     *
     * @param topic
     * @return
     */
    @Override
    public ResultVO update(Topic topic) {
        topicMapper.updateByPrimaryKeySelective(topic);
        return new SuccessVO();
    }

    /**
     * 新增topic
     *
     * @param topic
     * @return
     */
    @Override
    public ResultVO create(Topic topic) {
        topic.setTopicId(IdUtil.randomUUID());
        topicMapper.insert(topic);
        return new SuccessVO();
    }

    /**
     * 获取 某个topic详情
     *
     * @param topicId
     * @return
     */
    @Override
    public Topic getTopicOne(String topicId) {
        return topicMapper.selectByPrimaryKey(topicId);
    }

    /**
     * 获取话题的父话题
     *
     * @param topicId
     * @return
     */
    @Override
    public Topic getTopicFather(String topicId) {
        Topic topic = topicMapper.selectByPrimaryKey(topicId);
        return topic;
    }

    /**
     * 获取话题的子话题 列表
     *
     * @param topicId
     * @return
     */
    @Override
    public List<Topic> getTopicChild(String topicId) {
        Topic topic = new Topic();
        topic.setTopicFatherId(topicId);
        List<Topic> res = topicMapper.select(topic);
        return res;
    }

    /**
     * 模糊搜索话题
     *
     * @param keyword
     * @return
     */
    @Override
    public List<Topic> find(String keyword) {
        if ("".equals(keyword)) {
            return topicMapper.selectAll();
        }
        List<Topic> res = topicMapper.find(keyword);
        return res;
    }


}
