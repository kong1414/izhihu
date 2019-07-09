package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.PrivateMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository("PrivateMessageDAO")
public interface PrivateMessageMapper extends Mapper<PrivateMessage> {

    List<Map<String, Object>> list(@Param("userId") String userId);
}