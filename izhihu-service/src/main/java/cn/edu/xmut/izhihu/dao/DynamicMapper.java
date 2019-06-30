package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Dynamic;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("DynamicDAO")
public interface DynamicMapper extends Mapper<Dynamic> {
}