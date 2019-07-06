package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Favorite;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

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

    List<Favorite> getAttFavByUser(@Param("userId") String userId);

    /**
     * 根据id获取创建者的名字
     *
     * @param id
     * @return
     */
    @Select("SELECT users.`name` FROM favorite JOIN users " +
            "ON favorite.user_id = users.user_id " +
            "WHERE favorite.favorite_id = #{id}")
    String getUserNameByFavId(@Param("id") String id);


    /**
     * 搜索收藏夹下的文章
     *
     * @param id
     * @return
     */
    List<Map<String,Object>> getArticleByFav(@Param("id") String id);


}