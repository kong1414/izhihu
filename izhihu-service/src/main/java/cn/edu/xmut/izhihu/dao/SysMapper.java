package cn.edu.xmut.izhihu.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-10 10:45
 * @Version: 1.0
 */
@Repository
public interface SysMapper {
    List<Map<String, Object>> findArticle(@Param("keyword") String keyword);

    List<Map<String, Object>> findQues(@Param("keyword") String keyword);

    List<Map<String, Object>> findComment(@Param("keyword") String keyword);

    List<Map<String, Object>> findTopic(@Param("keyword") String keyword);

    List<Map<String, Object>> findFar(@Param("keyword") String keyword);


}
