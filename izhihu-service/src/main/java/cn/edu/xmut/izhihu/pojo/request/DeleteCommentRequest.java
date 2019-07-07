package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-03 23:27
 * @Version: 1.0
 */
@Data
public class DeleteCommentRequest {
    /**
     * 用户id
     */
    String userId;
    /**
     * 评论的id
     */
    String id;
}
