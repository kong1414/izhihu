package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-30 12:37
 * @Version: 1.0
 */
public interface FollowService {

    /**
     * 关注某事
     *
     * @param userId    用户id
     * @param contentId 内容id
     * @param type      类别
     * @return
     */
    public ResultVO infollow(String userId, String contentId, int type);

    /**
     * 取消关注某事
     *
     * @param userId    用户id
     * @param contentId 内容id
     * @return
     */
    public ResultVO unfollow(String userId, String contentId);

    /**
     * 是否已关注
     *
     * @param userId    用户id
     * @param contentId 内容id
     * @return
     */
    public Boolean checkFollow(String userId, String contentId);

    /**
     * 点赞某事
     *
     * @param userId    用户id
     * @param contentId 内容id
     * @return
     */
    public ResultVO like(String userId, String contentId);

    /**
     * 不赞成某事
     *
     * @param userId    用户id
     * @param contentId 内容id
     * @return
     */
    public ResultVO unlike(String userId, String contentId);

    /**
     * 取消点赞和不赞成，删除自己的态度
     *
     * @param userId    用户id
     * @param contentId 内容id
     * @return
     */
    public ResultVO cancelLike(String userId, String contentId);

    /**
     * 是否已点赞某事
     *
     * @param userId    用户id
     * @param contentId 内容id
     * @return
     */
    public Boolean checkLike(String userId, String contentId);

    /**
     * 是否已不赞成某事
     *
     * @param userId    用户id
     * @param contentId 内容id
     * @return
     */
    public Boolean checkUnLike(String userId, String contentId);

}
