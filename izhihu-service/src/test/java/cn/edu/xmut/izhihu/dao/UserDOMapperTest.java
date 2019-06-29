package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-29 21:24
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDOMapperTest {
    @Autowired
    UsersMapper usersMapper;

    @Test
    public void getUserDOByAccount() {
        UserDO userDO = usersMapper.getUserDOByAccount("13276966599");
        System.out.println(userDO.getEmail());
    }
}