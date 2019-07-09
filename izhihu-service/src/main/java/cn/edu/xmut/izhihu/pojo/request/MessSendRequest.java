package cn.edu.xmut.izhihu.pojo.request;
import lombok.Data;

import	java.util.Date;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-09 14:03
 * @Version: 1.0
 */
@Data
public class MessSendRequest {
    /**
     * 接收私信用户Id
     */
    private String takeinUserId;
    /**
     * 发送私信用户Id
     */
    private String sendUserId;
    /**
     * 私信内容
     */
    private String content;
}
