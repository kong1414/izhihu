package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.service.FollowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 12:53
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowServiceImplTest {

    @Autowired
    FollowService followService;

    @Test
    public void infollow() {
    }

    @Test
    public void unfollow() {
    }

    @Test
    public void checkFollow() {
        System.out.println(followService.checkFollow("c6c4cb00-9188-4722-9817-08b0c53aa182", "0c593ec4-feea-4751-99bd-bfee1434961e"));
    }
}