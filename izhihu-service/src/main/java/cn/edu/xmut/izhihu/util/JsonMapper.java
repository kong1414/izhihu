package cn.edu.xmut.izhihu.util;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class JsonMapper {

    private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        // 设置输出时包含属性的风格,使用输出非空属性到Json字符串
        // mapper.setSerializationConfig(mapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL));
        // mapper.getSerializationConfig().withSerializationInclusion(Inclusion.ALWAYS);
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        // mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
        // false);
        // // 禁止使用int代表Enum的order()來反序列化Enum,非常危險
        // mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS,
        // true);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 如果对象为Null, 返回"null". 如果集合为空集合, 返回"[]".
     */
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            // logger.warn("write to json string error:" + object, e);
            return null;
        }
    }

    /**
     * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
     * <p>
     * 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函數constructParametricType构造类型.
     *
     * @see #constructParametricType(Class, Class...)
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            logger.warn("parse json string error:" + jsonString, e);
            return null;
        }
    }

    /**
     * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
     * <p>
     * 如需读取集合如List/Map, 且不是List<String>这种简单类型时,先使用函數constructParametricType构造类型.
     *
     * @see #constructParametricType(Class, Class...)
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String jsonString, JavaType javaType) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return (T) mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            logger.warn("parse json string error:" + jsonString, e);
            return null;
        }
    }

    /**
     * 構造泛型的Type如List<MyBean>,
     * 则调用constructParametricType(ArrayList.class,MyBean.class)
     * Map<String,MyBean>则调用(HashMap.class,String.class, MyBean.class)
     */
    public static JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
        return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    /**
     * 當JSON裡只含有Bean的部分屬性時，更新一個已存在Bean，只覆蓋該部分的屬性.
     */
    public static <T> T update(T object, String jsonString) {
        try {
            return (T) mapper.readerForUpdating(object).readValue(jsonString);
        } catch (JsonProcessingException e) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        } catch (IOException e) {
            logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
        }
        return null;
    }

    /**
     * 輸出JSONP格式數據.
     */
    public static String toJsonP(String functionName, Object object) {
        return toJson(new JSONPObject(functionName, object));
    }

    /**
     * Map->Bean
     *
     * @param source
     * @param clazz
     * @return
     */
    public static <T> T toBean(Map<String, Object> source, Class<T> clazz) {
        String jsonString = toJson(source);
        T entity = fromJson(jsonString, clazz);
        return entity;
    }

    /**
     * List<Map> -> List<Bean>
     *
     * @param source
     * @param clazz
     * @return
     */
    public static <T> List<T> toBeanList(List<Map<String, Object>> source, Class<T> clazz) {
        List<T> list = Lists.newArrayList();
        for (Map<String, Object> each : source) {
            String jsonString = toJson(each);
            T entity = fromJson(jsonString, clazz);
            list.add(entity);
        }
        return list;
    }

    /**
     * 将json 转换为简单的 Java List/Map Object
     * <p>
     * 如果JSON字符串为Null或"null"字符串, 返回Null.<br>
     * 如果JSON字符串为"[]", 返回空集合.<br>
     * 如果转换出现异常，返回Null
     * <p>
     * example:
     *
     * <pre>
     *
     * List&lt;Bean&gt; result = JsonUtil.fromJson(source, new TypeReference&lt;List&lt;Bean&gt;&gt;() {
     * });
     * </pre>
     *
     * @param jsonString 输入的json字符串
     * @param type       需要转换得到的结果类型。使用 new JsonTypeReference构造
     * @return 转换后的Java对象
     */
    public static <T> T fromJson(String jsonString, TypeReference<T> type) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, type);
        } catch (IOException e) {
            logger.error("parse json string error:" + jsonString, e);
            return null;
        }
    }

    /**
     * 取出Mapper做进一步的设置或使用其他序列化API.
     */
    public static ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * 设定是否使用Enum的的toString函数来读写枚举， 为False时使用Enum的name()函数来读写枚举，默认为False。
     * 注意本函数一定要在Mapper创建后，所有的读写动作之前调用。
     */
    public static void setEnumUseToString(boolean value) {
        // mapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING,
        // value);
        // mapper.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING,
        // value);
    }
}
