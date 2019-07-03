package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-01 15:55
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicMapperTest {

    @Autowired
    TopicMapper topicMapper;

    @Test
    public void getTopicRandom() {
        List<Topic> list = topicMapper.getTopicRandom(3);
        System.out.println(list);
    }

    @Test
    public void getTopicArticle() {
        topicMapper.getTopicArticle("0001");
    }
}