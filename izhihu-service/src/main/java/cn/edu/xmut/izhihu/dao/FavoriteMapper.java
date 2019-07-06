package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Favorite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("FavoriteDAO")
public interface FavoriteMapper extends Mapper<Favorite> {

    /**
     * 查询某收藏夹关联文章的数量
     *
     * @param id
     * @return
     */
    int countFavArt(@Param("id") String id);

    /**
     * 查询某收藏夹被关注的数量
     *
     * @param id
     * @return
     */
    int countFavAtt(@Param("id") String id);

    /**
     * 随机取得收藏夹
     *
     * @param num
     * @return
     */
    List<Favorite> getFavRandom(@Param("num") int num);

}