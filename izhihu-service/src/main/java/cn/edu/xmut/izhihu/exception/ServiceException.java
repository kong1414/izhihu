package cn.edu.xmut.izhihu.exception;

/**
 * @Author: QiuGuanLin
 * @Description:
 * @Date: 23:33 2018/9/28
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String msg) {
        super(msg);
    }
}
