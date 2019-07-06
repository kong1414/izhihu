package cn.edu.xmut.izhihu.pojo.vo;

import cn.edu.xmut.izhihu.pojo.entity.Article;
import cn.edu.xmut.izhihu.pojo.entity.Favorite;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-06 23:27
 * @Version: 1.0
 */
@Data
public class FavoriteDetailVO {

    private Favorite favorite;
    private int attNum;
    private String userName;
    List<Map<String, Object>> articleList;
}
