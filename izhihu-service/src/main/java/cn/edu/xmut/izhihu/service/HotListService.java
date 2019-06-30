package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-27 14:42
 * @Version: 1.0
 */
public interface HotListService {

    /**
     * 根据
     *
     * @param categoryType
     * @return
     */
    public ResultVO list(int categoryType);
}
