package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.MessSendRequest;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-09 13:58
 * @Version: 1.0
 */
public interface MessageService {


    /**
     * 获取私信信息
     *
     * @param userId
     * @return
     */
    ResultVO list(String userId);

    /**
     * 发送私信
     *
     * @return
     */
    ResultVO send(MessSendRequest record);

    /**
     * 删除私信
     *
     * @param id
     * @return
     */
    ResultVO del(String id);


    /**
     * 已读
     *
     * @param id
     * @return
     */
    ResultVO read(String id);
}
