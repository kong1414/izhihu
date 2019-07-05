package com.demo2.exception;


import com.demo2.pojo.common.HttpCodeEnum;

/**
 * 业务异常：未登录或登录过期
 *
 * @author czj
 * @version 1.0
 * @datetime 11:30:53 AM, Jun 15, 2018
 */
public class NoLoginException extends BussinessException {

    private static final long serialVersionUID = 864298927235774105L;

    /**
     * 业务异常：未登录或登录过期
     */
    public NoLoginException() {
        this("未登录或登录过期！");
    }

    /**
     * 业务异常：未登录或登录过期
     *
     * @param message
     */
    public NoLoginException(String message) {
        this(null, message);
    }

    /**
     * 业务异常：未登录或登录过期
     *
     * @param data
     * @param message
     */
    public NoLoginException(Object data, String message) {
        super(HttpCodeEnum.NO_LOGIN.getCode(), data, message);
    }

}
