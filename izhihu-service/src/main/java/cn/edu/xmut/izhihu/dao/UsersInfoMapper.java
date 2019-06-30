package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.UsersInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("UsersInfoDAO")
public interface UsersInfoMapper extends Mapper<UsersInfo> {
}