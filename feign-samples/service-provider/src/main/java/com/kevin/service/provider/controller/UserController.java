package com.kevin.service.provider.controller;

import com.kevin.service.provider.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 *
 * @author wangyong
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${server.port}")
    private String port;

    @Autowired
    private Environment environment;


    /**
     * 获取用户信息
     *
     * @param userName 用户名
     */
    @GetMapping("/getUser/{userName}")
    public User getUser(@PathVariable String userName) {
        logger.info("[getUser]-{}", userName);
        logger.info("当前服务对外开放端口:{}", environment.getProperty("local.server.port"));
        return new User(userName, "普通用户");
    }


}
