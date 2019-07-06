package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.FavoriteArticleMapper;
import cn.edu.xmut.izhihu.dao.FavoriteMapper;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.Favorite;
import cn.edu.xmut.izhihu.pojo.entity.FavoriteArticle;
import cn.edu.xmut.izhihu.pojo.request.CreateFavoriteRequest;
import cn.edu.xmut.izhihu.pojo.request.UpdateFavoriteRequest;
import cn.edu.xmut.izhihu.pojo.vo.CollectDetailVO;
import cn.edu.xmut.izhihu.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-06 18:34
 * @Version: 1.0
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private FavoriteArticleMapper favArtMapper;


    /**
     * 获取我的收藏
     *
     * @param userId
     * @return
     */
    @Override
    public ResultVO myFavorite(String userId) {
        Example example = new Example(Favorite.class);
        example.createCriteria()
                .andEqualTo("userId", userId);
        List<Favorite> record = favoriteMapper.selectByExample(example);
        return new SuccessVO(record);
    }

    @Override
    public ResultVO myFavoriteDetail(String userId) {
        CollectDetailVO record = new CollectDetailVO();
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        List<Favorite> list = favoriteMapper.select(favorite);

        for (Favorite i : list) {
            int contNum = favoriteMapper.countFavArt(i.getFavoriteId());
            int attNum = favoriteMapper.countFavAtt(i.getFavoriteId());
            //TODO:
        }


        return new SuccessVO();
    }

    /**
     * 创建收藏夹
     *
     * @param record
     * @return
     */
    @Override
    public ResultVO create(CreateFavoriteRequest record) {
        Favorite favorite = new Favorite();
        favorite.setUserId(record.getUserId());
        favorite.setFavoriteName(record.getName());
        favorite.setDescribe(record.getDescribe());
        favorite.setIsPublic(record.getIsPublic());
        favoriteMapper.insertSelective(favorite);
        return new SuccessVO("创建成功");
    }

    /**
     * 更新收藏夹
     *
     * @param record
     * @return
     */
    @Override
    public ResultVO update(UpdateFavoriteRequest record) {
        Favorite favorite = new Favorite();
        favorite.setFavoriteId(record.getFavoriteId());
        favorite.setFavoriteName(record.getName());
        favorite.setDescribe(record.getDescribe());
        favorite.setIsPublic(record.getIsPublic());
        favoriteMapper.updateByPrimaryKeySelective(favorite);
        return new SuccessVO("更新成功");
    }

    /**
     * 删除收藏夹
     *
     * @param favoriteId
     * @return
     */
    @Override
    public ResultVO del(String favoriteId) {
        int num = favoriteMapper.countFavArt(favoriteId);

        if (num > 0) {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "该收藏夹有关联的文章");
        }
        favoriteMapper.deleteByPrimaryKey(favoriteId);
        return new SuccessVO("删除成功");
    }

    /**
     * 热门收藏夹
     *
     * @param num 代表需要返回几条数据
     * @return
     */
    @Override
    public ResultVO hotFavorite(int num) {

        return null;
    }

    /**
     * 收藏
     *
     * @param favoritesId
     * @param articleId
     * @return
     */
    @Override
    public ResultVO collect(String favoritesId, String articleId) {
        FavoriteArticle record = new FavoriteArticle();
        record.setFavoritesId(favoritesId);
        record.setArticleId(articleId);
        favArtMapper.insertSelective(record);
        return new SuccessVO();
    }

    /**
     * 取消收藏
     *
     * @param favoritesId
     * @param articleId
     * @return
     */
    @Override
    public ResultVO unCollect(String favoritesId, String articleId) {
        favArtMapper.delCollect(favoritesId, articleId);
        return new SuccessVO("取消收藏成功");
    }


}
