package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Favorite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("FavoriteDAO")
public interface FavoriteMapper extends Mapper<Favorite> {

    /**
     * 查询收藏夹关联文章的数量
     *
     * @param id
     * @return
     */
    int countFavArt(@Param("id") String id);
}