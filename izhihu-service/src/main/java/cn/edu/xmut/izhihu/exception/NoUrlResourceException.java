package cn.edu.xmut.izhihu.exception;


import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;

/**
 * 业务异常：找不到请求
 *
 * @author czj
 * @version 1.0
 * @datetime 11:46:50 AM, Jun 15, 2018
 */
public class NoUrlResourceException extends BussinessException {

    private static final long serialVersionUID = 5212551713966817211L;

    /**
     * 业务异常：找不到请求
     */
    public NoUrlResourceException() {
        this("找不到请求！");
    }

    /**
     * 业务异常：找不到请求
     *
     * @param message
     */
    public NoUrlResourceException(String message) {
        this(null, message);
    }

    /**
     * 业务异常：找不到请求
     *
     * @param data
     * @param message
     */
    public NoUrlResourceException(Object data, String message) {
        super(HttpCodeEnum.NO_URL_RESOURCE.getCode(), data, message);
    }

}
