package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.AgreeOppose;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("AgreeOpposeDAO")
public interface AgreeOpposeMapper extends Mapper<AgreeOppose> {
}