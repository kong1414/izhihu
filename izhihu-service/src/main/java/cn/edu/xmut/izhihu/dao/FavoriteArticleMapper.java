package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.FavoriteArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface FavoriteArticleMapper extends Mapper<FavoriteArticle> {

    /**
     * 取消收藏
     *
     * @param favoritesId
     * @param articleId
     */
    void delCollect(@Param("favoritesId") String favoritesId,
                    @Param("articleId") String articleId);
}