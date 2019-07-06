package cn.edu.xmut.izhihu.pojo.vo;

import cn.edu.xmut.izhihu.pojo.entity.Favorite;
import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-06 19:15
 * @Version: 1.0
 */
@Data
public class CollectDetailVO {
    private Favorite favorite;
    private int attNum;
    private int contentNum;
}
