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

    Integer browseNum();
    Integer artNum();
    Integer quesNum();
    Integer commentNum();
    Integer agreeNum();
    Integer attNum();
    Integer topicNum();
    Integer userNum();

    List<Map<String,Object>> artAna();
    List<Map<String,Object>> quesAna();
    List<Map<String,Object>> comAna();

    List<Map<String,Object>> findUser(@Param("keyword") String keyword);


}
