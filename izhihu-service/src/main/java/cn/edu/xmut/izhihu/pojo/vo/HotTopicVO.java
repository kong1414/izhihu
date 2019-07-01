package cn.edu.xmut.izhihu.pojo.vo;

import lombok.Data;

/**
 * @Description: 热门话题列表pojo（发现页）
 * @Author: qiuguanlin
 * @Date: 2019-07-01 09:06
 * @Version: 1.0
 */
@Data
public class HotTopicVO {
    /**
     * 话题id
     */
    private String topicId;
    /**
     * 话题名称
     */
    private String topicName;
    /**
     * 话题图片
     */
    private String photoUrl;
    /**
     * 关注人数
     */
    private int attNum;
}
