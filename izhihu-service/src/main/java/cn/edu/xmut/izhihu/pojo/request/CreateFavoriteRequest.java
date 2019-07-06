package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-06 18:39
 * @Version: 1.0
 */
@Data
public class CreateFavoriteRequest {
    private String userId;
    private String name;
    private String describes;
    private int isPublic;
}
