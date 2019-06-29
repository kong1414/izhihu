package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Inviter;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("InviterDAO")
public interface InviterMapper extends Mapper<Inviter> {
}