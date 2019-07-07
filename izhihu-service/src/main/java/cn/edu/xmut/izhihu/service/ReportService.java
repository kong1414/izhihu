package cn.edu.xmut.izhihu.service;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.ReportRequest;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-07 16:07
 * @Version: 1.0
 */
public interface ReportService {

    /**
     * 进行举报
     *
     * @param record
     * @return
     */
    ResultVO report(ReportRequest record);
}
