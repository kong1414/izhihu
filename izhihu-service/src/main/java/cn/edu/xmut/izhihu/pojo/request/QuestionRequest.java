package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @Description: 问题的请求类
 * @Author: qiuguanlin
 * @Date: 2019-06-26 21:49
 * @Version: 1.0
 */
@Data
public class QuestionRequest {
    /**
     * 问题名称
     */
    @NotBlank(message = "不允许为空")
    @Length(min = 4, max = 50, message = "name 长度必须在 {min} - {max} 之间")
    private String quesName;
    /**
     * 提问人id
     */
    @NotBlank(message = "不允许为空")
    private String questionerId;

    /**
     * 图片url
     */
    private String photoUrl;

    /**
     * 问题描述
     */
    private String quesDescribe;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 匿名（1是/0否）
     */
    private Integer anonymity;

    /**
     * 关联的话题列表
     */
    private List<String> topicList;

}
