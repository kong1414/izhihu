package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.CreateFavoriteRequest;
import cn.edu.xmut.izhihu.pojo.request.UpdateFavoriteRequest;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-06 18:34
 * @Version: 1.0
 */
public interface FavoriteService {

    /**
     * 获取我的收藏列表
     *
     * @param userId
     * @return
     */
    public ResultVO myFavorite(String userId);

    /**
     * 获取我的收藏详情 增加关注人数以及内容数量
     *
     * @param userId
     * @return
     */
    public ResultVO myFavoriteDetail(String userId);


    /**
     * 创建收藏夹
     *
     * @param record
     * @return
     */
    public ResultVO create(CreateFavoriteRequest record);

    /**
     * 更新收藏夹
     *
     * @param record
     * @return
     */
    public ResultVO update(UpdateFavoriteRequest record);

    /**
     * 删除收藏夹
     *
     * @param favoriteId
     * @return
     */
    public ResultVO del(String favoriteId);

    /**
     * 热门收藏夹
     *
     * @param num 代表需要返回几条数据
     * @return
     */
    ResultVO hotFavorite(int num);

    /**
     * 收藏
     *
     * @param favoritesId
     * @param articleId
     * @return
     */
    ResultVO collect(String favoritesId, String articleId);

    /**
     * 取消收藏
     *
     * @param favoritesId
     * @param articleId
     * @return
     */
    ResultVO unCollect(String favoritesId, String articleId);
}
