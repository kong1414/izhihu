package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.FavoriteArticle;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface FavoriteArticleMapper extends Mapper<FavoriteArticle> {
}