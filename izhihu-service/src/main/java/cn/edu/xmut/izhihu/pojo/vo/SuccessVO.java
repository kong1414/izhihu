package cn.edu.xmut.izhihu.pojo.vo;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @Date: 2018/12/24 9:15
 * @version: 1.0
 */
public class SuccessVO<T> extends ResultVO<T> {

    public SuccessVO() {
        this(null, "");
    }

    public SuccessVO(String resultMessage) {
        this(null, resultMessage);
    }

    public SuccessVO(T data, String resultMessage) {
        super(HttpCodeEnum.REQUEST_SUCCESS.getCode(), data, resultMessage);
    }

}