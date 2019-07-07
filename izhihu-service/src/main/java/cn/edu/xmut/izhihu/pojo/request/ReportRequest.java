package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-07 16:09
 * @Version: 1.0
 */
@Data
public class ReportRequest {

    /**
     * 举报类型
     */
    private String reportType;

    /**
     * 举报人
     */
    private String userId;

    /**
     * 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
     */
    private Integer type;

    /**
     * 内容id
     */
    private String contentId;

    /**
     * 举报内容
     */
    private String reportContent;
}
