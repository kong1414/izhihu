package com.demo2.pojo.common;

/**
 * @Description: 动作的状态枚举
 * 动作（1发表2赞同3收藏4关注）
 * @Author: qiuguanlin
 * @Date: 2019-06-28 22:35
 * @Version: 1.0
 */
public enum Action {
    /**
     * 1发表
     */
    PUBLISH(1),
    /**
     * 2赞同
     */
    AGREE(2),
    /**
     * 3收藏
     */
    COLLECT(3),
    /**
     * 4关注
     */
    ATTENTION(4);

    private Integer code;

    Action(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

