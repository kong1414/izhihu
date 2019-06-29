package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Favorite;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("FavoriteDAO")
public interface FavoriteMapper extends Mapper<Favorite> {
}