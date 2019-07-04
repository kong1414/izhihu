package cn.edu.xmut.izhihu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-04 09:05
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
    @Autowired
    CommentMapper commentMapper;

    @Test
    public void findByContentId() {

        List<Map<String, Object>> list = commentMapper.findByContentId("0c593ec4-feea-4751-99bd-bfee1434961e");
        System.out.println(list);
    }
}