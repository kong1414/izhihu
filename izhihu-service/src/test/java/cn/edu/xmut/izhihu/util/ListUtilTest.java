package cn.edu.xmut.izhihu.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-07 15:50
 * @Version: 1.0
 */
public class ListUtilTest {

    @Test
    public void removeRepeatMapByKey() {

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("key1", "val1");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("key1", "val1");
        Map<String, Object> map3 = new HashMap<>();
        map2.put("key1", "val2");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        //打印list里面的数据

        ListUtil.removeRepeatMapByKey(list, "key1");
    }
}