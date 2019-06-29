package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.ColumnDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("ColumnDAO")
public interface ColumnMapper extends Mapper<ColumnDO> {
}