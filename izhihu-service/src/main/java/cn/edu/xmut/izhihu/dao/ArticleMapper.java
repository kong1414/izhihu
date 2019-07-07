package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository("ArticleDAO")
public interface ArticleMapper extends Mapper<Article> {

    /**
     * 随机文章一次获取10条
     *
     * @return
     */
    List<Map<String, Object>> getArticleRandom();

    List<Map<String, Object>> todayHot();

    List<Map<String, Object>> monthHot();

    /**
     * 获取用户的所有文章信息
     *
     * @param userId
     * @param type
     * @return
     */
    List<Map<String, Object>> getArticleByUser(@Param("userId") String userId,
                                               @Param("type") int type);
}