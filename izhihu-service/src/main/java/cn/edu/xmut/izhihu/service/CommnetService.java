package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.CommentRequest;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-03 23:16
 * @Version: 1.0
 */
public interface CommnetService {

    /**
     * 获取某内容的评论
     *
     * @param contentId
     * @return
     */
    List<Map<String, Object>> find(String contentId);

    /**
     * 进行评论
     *
     * @param record
     * @return
     */
    ResultVO comment(CommentRequest record);

    /**
     * 进行评论
     *
     * @param userId
     * @param id
     * @return
     */
    ResultVO delete(String userId, String id);

}
