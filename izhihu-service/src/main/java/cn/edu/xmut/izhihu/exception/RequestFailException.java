package cn.edu.xmut.izhihu.exception;

import cn.edu.xmut.izhihu.pojo.vo.HttpCodeEnum;

/**
 * 业务异常：请求处理失败
 *
 * @author czj
 * @version 1.0
 * @datetime 11:40:23 AM, Jun 15, 2018
 */
public class RequestFailException extends BussinessException {

    private static final long serialVersionUID = 1383578830912760409L;

    /**
     * 业务异常：请求处理失败
     */
    public RequestFailException() {
        this("请求处理失败！");
    }

    /**
     * 业务异常：请求处理失败
     *
     * @param message
     */
    public RequestFailException(String message) {
        this(null, message);
    }

    /**
     * 业务异常：请求处理失败
     *
     * @param data
     * @param message
     */
    public RequestFailException(Object data, String message) {
        super(HttpCodeEnum.REQUEST_FAIL.getCode(), data, message);
    }

}
