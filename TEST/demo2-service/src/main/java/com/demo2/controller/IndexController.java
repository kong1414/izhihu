package com.demo2.controller;

import com.demo2.dao.UserMapper;
import com.demo2.pojo.common.ResultVO;
import com.demo2.pojo.common.SuccessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-05 12:14
 * @Version: 1.0
 */
@RestController
@RequestMapping("/hello")
public class IndexController {

    @Autowired
    UserMapper userMapper;


    @RequestMapping("/user")
    public ResultVO index() {
        return new SuccessVO(userMapper.selectAll());
    }

}
