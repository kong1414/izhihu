package cn.edu.xmut.izhihu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Action;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-02 20:30
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersMapperTest {

    @Autowired
    UsersMapper usersMapper;

    @Test
    public void userInfo() {
        System.out.println(usersMapper.userInfo("c6c4cb00-9188-4722-9817-08b0c53aa182"));

    }
}