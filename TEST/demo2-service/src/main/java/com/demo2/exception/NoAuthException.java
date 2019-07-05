package com.demo2.exception;


import com.demo2.pojo.common.HttpCodeEnum;

/**
 * 业务异常：未授权或认证失败
 *
 * @author czj
 * @version 1.0
 * @datetime 11:43:28 AM, Jun 15, 2018
 */
public class NoAuthException extends BussinessException {

    private static final long serialVersionUID = -1752470812982116546L;

    /**
     * 业务异常：未授权或认证失败
     */
    public NoAuthException() {
        this("未授权或认证失败！");
    }

    /**
     * 业务异常：未授权或认证失败
     *
     * @param message
     */
    public NoAuthException(String message) {
        this(null, message);
    }

    /**
     * 业务异常：未授权或认证失败
     *
     * @param data
     * @param message
     */
    public NoAuthException(Object data, String message) {
        super(HttpCodeEnum.NO_AUTH.getCode(), data, message);
    }

}
