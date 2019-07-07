package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.ReportMapper;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.Report;
import cn.edu.xmut.izhihu.pojo.request.ReportRequest;
import cn.edu.xmut.izhihu.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-07 16:07
 * @Version: 1.0
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    /**
     * 进行举报
     *
     * @param record
     * @return
     */
    @Override
    public ResultVO report(ReportRequest record) {

        Report report = new Report();
        report.setReportType(record.getReportType());
        report.setUserId(record.getUserId());
        report.setType(record.getType());
        report.setContentId(record.getContentId());
        report.setReportContent(record.getReportContent());

        reportMapper.insertSelective(report);
        return new SuccessVO("举报成功");
    }
}
