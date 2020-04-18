package com.kevin.service.consumer.controller;

import com.kevin.service.consumer.domain.User;
import com.kevin.service.consumer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 获取用户
     */
    @GetMapping("/create/{userName}")
    public User createUser(@PathVariable String userName) {
        logger.info("[createUser]-{}", userName);
        return userService.getUser(userName);
    }


}
