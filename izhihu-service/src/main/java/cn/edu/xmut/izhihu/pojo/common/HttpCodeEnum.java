package cn.edu.xmut.izhihu.pojo.common;


/**
 * @author yangyx
 * @version 1.0
 * @Description: http状态枚举
 * @Date: 2018/9/10 15:49
 */
public enum HttpCodeEnum {

    /**
     * 请求成功，代码200
     */
    REQUEST_SUCCESS(200),

    /**
     * 未登录或登录过期，代码300
     */
    NO_LOGIN(300),

    /**
     * 请求处理失败，代码400
     */
    REQUEST_FAIL(400),

    /**
     * 未授权或认证失败，代码401
     */
    NO_AUTH(401),

    /**
     * 找不到请求，代码404
     */
    NO_URL_RESOURCE(404),

    /**
     * 系统内部异常，代码500
     */
    SYSTEM_ERROR(500);

    private Integer code;

    HttpCodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
