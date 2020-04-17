package com.kevin.service.consumer.controller;

import com.kevin.service.consumer.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author wangyong
 */
@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * 获取用户
     */
    @GetMapping("/create/{userName}")
    public User getUser(@PathVariable String userName) {
        return new User(userName, "默认用户");
    }


}
