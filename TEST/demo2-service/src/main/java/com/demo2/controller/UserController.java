package com.demo2.controller;

import com.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-05 12:20
 * @Version: 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

}
