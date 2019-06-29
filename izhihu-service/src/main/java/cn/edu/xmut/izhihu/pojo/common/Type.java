package cn.edu.xmut.izhihu.pojo.common;

/**
 * @Description: type状态枚举
 * 类别（1回答，2文章，3想法，4问题，5话题，6用户，7收藏夹，8专栏）
 * @Author: qiuguanlin
 * @Date: 2019-06-28 22:30
 * @Version: 1.0
 */
public enum Type {
    /**
     * 1回答
     */
    ANSWER(1),
    /**
     * 2文章
     */
    ARTICLE(2),
    /**
     * 3想法
     */
    IDEA(3),
    /**
     * 4问题
     */
    QUESTION(4),
    /**
     * 5话题
     */
    TOPIC(5),
    /**
     * 用6户
     */
    USER(6),
    /**
     * 7收藏夹
     */
    FAVORITE(7),
    /**
     * 8专栏
     */
    COLUMN(8);

    private Integer code;

    Type(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
