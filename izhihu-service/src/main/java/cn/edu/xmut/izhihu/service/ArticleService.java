package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.ArticleRequest;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:41
 * @Version: 1.0
 */
public interface ArticleService {

    /**
     * 创建文章想法
     *
     * @param record
     * @return
     */
    ResultVO create(ArticleRequest record);

    /**
     * 首页推荐文章
     *
     * @return
     */
    ResultVO recommend();

    /**
     * 今日最热
     *
     * @return
     */
    ResultVO todayHot();

    /**
     * 本月最热
     *
     * @return
     */
    ResultVO monthHot();

    /**
     * 获取用户的所有文章信息
     *
     * @param userId
     * @param type   类别（1回答，2文章，3想法）
     *               类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     * @return
     */
    ResultVO getArticleByUser(String userId, int type);


    /**
     * 首页的关注内容
     *
     * @param userId
     * @return
     */
    ResultVO attContetn(String userId);

    /**
     * 删除文章
     *
     * @param userId
     * @param artiId
     * @return
     */
    ResultVO delete(String userId, String artiId);
}
