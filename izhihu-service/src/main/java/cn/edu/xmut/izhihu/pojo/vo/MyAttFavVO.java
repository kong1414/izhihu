package cn.edu.xmut.izhihu.pojo.vo;

import cn.edu.xmut.izhihu.pojo.entity.Favorite;
import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-06 21:32
 * @Version: 1.0
 */
@Data
public class MyAttFavVO {
    private Favorite favorite;
    private String userName;
    private int contentNum;
    private int attNum;

}
