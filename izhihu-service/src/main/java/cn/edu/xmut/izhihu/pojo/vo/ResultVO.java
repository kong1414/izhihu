package cn.edu.xmut.izhihu.pojo.vo;

/**
 * @Description:
 * @Author: QiuGuanLin
 * @version: 2.0
 * @Date: 2018/9/10 22:13
 */
public class ResultVO<T> {

    /**
     * 代码
     */
    private int resultCode;

    /**
     * 成功时返回的数据
     */
    private T data;

    private String resultMessage;

    public ResultVO() {
        this.resultCode = HttpCodeEnum.REQUEST_SUCCESS.getCode();
        this.resultMessage = "";
        this.data = null;
    }

    // 错误时的构造器
    public ResultVO(int resultCode, T data, String resultMessage) {
        this.resultCode = resultCode;
        this.data = data;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "JsonResult [resultCode=" + resultCode + ", data=" + data + ", resultMessage=" + resultMessage + "]";
    }
}

