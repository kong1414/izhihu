package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.ArticleRequest;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:41
 * @Version: 1.0
 */
public interface ArticleService {

    /**
     * 创建文章想法
     *
     * @param record
     * @return
     */
    ResultVO create(ArticleRequest record);

}
