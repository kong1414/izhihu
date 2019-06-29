package cn.edu.xmut.izhihu.exception;

import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;

/**
 * 业务异常
 *
 * @author czj
 * @version 1.0
 * @datetime 12:01:29 PM, May 31, 2018
 */
public abstract class BussinessException extends Exception {

    private static final long serialVersionUID = -1938028561525752600L;

    /**
     * 异常代码
     */
    private int code;

    /**
     * 异常内容
     */
    private Object data;

    /**
     * 业务异常
     */
    public BussinessException() {
        this(HttpCodeEnum.SYSTEM_ERROR.getCode(), "系统异常，请联系管理员！");
    }

    /**
     * 业务异常
     *
     * @param code
     * @param message
     */
    public BussinessException(int code, String message) {
        this(code, null, message);
    }

    /**
     * 业务异常
     *
     * @param code
     * @param data
     * @param message
     */
    public BussinessException(int code, Object data, String message) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
