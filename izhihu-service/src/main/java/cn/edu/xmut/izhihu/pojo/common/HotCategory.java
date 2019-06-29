package cn.edu.xmut.izhihu.pojo.common;

/**
 * @Description: 热榜的类别枚举
 * 类别（0全部1科学2数码3体育4时尚5影视）
 * @Author: qiuguanlin
 * @Date: 2019-06-28 22:38
 * @Version: 1.0
 */
public enum HotCategory {
    /**
     * 全部
     */
    ALL(0),
    /**
     * 科学
     */
    science(1),
    /**
     * 数码
     */
    digital(2),
    /**
     * 体育
     */
    sports(3),
    /**
     * 时尚
     */
    fashion(4),
    /**
     * 影视
     */
    video(5);

    private Integer code;

    HotCategory(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
