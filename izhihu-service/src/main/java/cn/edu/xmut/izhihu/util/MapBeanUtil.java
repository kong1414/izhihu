package cn.edu.xmut.izhihu.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 9:07 2018/10/24
 */
public class MapBeanUtil {

    /**
     * 将一个 Map 对象转化为一个 JavaBean
     *
     * @param map    包含属性值的 map
     * @param class1 转化出来的 JavaBean 对象
     * @param <T>
     * @return
     * @throws InstantiationException    如果实例化 JavaBean 失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> class1)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
        T bean = class1.newInstance();
        BeanUtils.populate(bean, map);
        return bean;
    }
}
