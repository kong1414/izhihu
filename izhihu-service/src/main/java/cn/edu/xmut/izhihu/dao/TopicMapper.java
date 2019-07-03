package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Topic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository("TopicDAO")
public interface TopicMapper extends Mapper<Topic> {


    /**
     * 随机获取num个话题
     *
     * @return
     */
    public List<Topic> getTopicRandom(@Param("num") int num);

    /**
     * 获取某个话题下，回答的内容
     *
     * @param topicId
     * @return
     */
    public List<Map<String, Object>> getTopicArticle(@Param("topicId") String topicId);

    /**
     * 获取已关注话题
     *
     * @param userId
     * @return
     */
    public List<Topic> getAttedTopic(@Param("userId") String userId);

    /**
     * 模糊搜索根据关键字
     *
     * @param keyword
     * @return
     */
    @Select("select * from topic where topic_name LIKE '%#{keyword}%'")
    List<Topic> find(String keyword);

}