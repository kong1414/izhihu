package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.HotList;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("HotListDAO")
public interface HotListMapper extends Mapper<HotList> {
}