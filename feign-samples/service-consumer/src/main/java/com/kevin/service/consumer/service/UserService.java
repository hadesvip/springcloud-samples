package com.kevin.service.consumer.service;

import com.kevin.service.consumer.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务
 *
 * @author wangyong
 */
@FeignClient("service-provider")
public interface UserService {

    @GetMapping("/user/getUser/{userName}")
    User getUser(@PathVariable(value = "userName") String userName);
}
