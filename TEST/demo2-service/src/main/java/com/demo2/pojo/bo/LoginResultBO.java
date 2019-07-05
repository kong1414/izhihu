package com.demo2.pojo.bo;

import com.demo2.pojo.vo.UserVO;
import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-29 20:47
 * @Version: 1.0
 */
@Data
public class LoginResultBO {

    private boolean success;

    private String msg;

    private UserVO userVO;
}
