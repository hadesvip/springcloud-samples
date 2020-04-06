package com.kevin.eureka.client.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 用户
 *
 * @author wangyong
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getCurrDateTime")
    public String getCurrDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
