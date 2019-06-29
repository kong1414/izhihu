package cn.edu.xmut.izhihu.test;

import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-29 20:58
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HutoolTest {
    @Test
    public void fun() {
        System.out.println(IdUtil.randomUUID());
    }
}
