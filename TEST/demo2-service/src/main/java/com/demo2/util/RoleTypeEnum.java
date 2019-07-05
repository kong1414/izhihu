package com.demo2.util;

/**
 * @Author: QiuGuanLin
 * @Description: 角色的类型：
 * 0，用户
 * 1，超级管理员
 * 2，超级管理员
 * 3：销售管理员
 * 4，仓库管理员
 * @Date: 11:41 2018/9/27
 */
public enum RoleTypeEnum {
    /**
     * 普通用户
     */
    USER(0),
    /**
     * 超级管理员
     */
    SUPER_ADMIN(1),
    /**
     * 普通管理员
     */
    ADMIN(2),
    /**
     * 销售管理员
     */
    SALES_MANAGER(3),
    /**
     * 仓库管理员
     */
    WAREHOUSE_MANAGER(4);

    private Integer code;

    RoleTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
