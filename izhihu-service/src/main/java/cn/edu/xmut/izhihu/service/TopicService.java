package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.entity.Topic;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-01 15:28
 * @Version: 1.0
 */
public interface TopicService {

    /**
     * 随机获取num个话题
     *
     * @param num
     * @return
     */
    public List<Topic> getTopicRandom(int num);

    /**
     * 获取某个Topic下的热门文章
     *
     * @param topicId
     * @return
     */
    List<Map<String, Object>> getTopicArticle(String topicId);

    /**
     * 获取已关注的话题
     *
     * @param userId
     * @return
     */
    List<Topic> getAttedTopic(String userId);

    /**
     * 关联话题，把话题关联起来（后台的）
     *
     * @param id  子id
     * @param fId 父id
     */
    void relevanceTopic(String id, String fId);

    /**
     * 删除话题有关联话题时无法删除
     *
     * @param topicId
     */
    ResultVO delete(String topicId);

    /**
     * 删除话题 有关联话题会连级删除
     *
     * @param topicId
     */
    ResultVO forceDelete(String topicId);

    /**
     * 更新topic
     *
     * @param topic
     * @return
     */
    ResultVO update(Topic topic);

    /**
     * 新增topic
     *
     * @param topic
     * @return
     */
    ResultVO create(Topic topic);

    /**
     * 获取 某个topic详情
     *
     * @param topicId
     * @return
     */
    Topic getTopicOne(String topicId);

    /**
     * 获取话题的父话题
     *
     * @param topicId
     * @return
     */
    Topic getTopicFather(String topicId);

    /**
     * 获取话题的子话题
     *
     * @param topicId
     * @return
     */
    List<Topic> getTopicChild(String topicId);

    /**
     * 模糊搜索话题
     *
     * @param keyword
     * @return
     */
    List<Topic> find(String keyword);

    /**
     * 获取关注人数最多的话题
     *
     * @return
     */
    ResultVO hotTopic();

}
