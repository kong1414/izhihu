package com.demo2.exception;


import com.demo2.pojo.common.HttpCodeEnum;

/**
 * 业务异常：系统内部异常
 *
 * @author czj
 * @version 1.0
 * @datetime 11:48:50 AM, Jun 15, 2018
 */
public class SystemErrorException extends BussinessException {

    private static final long serialVersionUID = -2448268895255277520L;

    /**
     * 业务异常：系统内部异常
     */
    public SystemErrorException() {
        this("系统异常，请联系管理员！");
    }

    /**
     * 业务异常：系统内部异常
     *
     * @param message
     */
    public SystemErrorException(String message) {
        this(null, message);
    }

    /**
     * 业务异常：系统内部异常
     *
     * @param data
     * @param message
     */
    public SystemErrorException(Object data, String message) {
        super(HttpCodeEnum.SYSTEM_ERROR.getCode(), data, message);
    }

}
