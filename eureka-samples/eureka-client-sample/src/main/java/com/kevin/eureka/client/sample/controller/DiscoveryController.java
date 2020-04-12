package com.kevin.eureka.client.sample.controller;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Discovery
 *
 * @author wangyong
 */
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取服务列表
     */
    @GetMapping("/getServices")
    public Set<String> getServices() {
        return Sets.newHashSet(discoveryClient.getServices());
    }

    /**
     * 获取服务实例列表
     *
     * @PathVariable spring提供的
     * @PathParam 属于JAX-RS标准的Java REST 注解
     */
    @GetMapping("/services/{serviceName}")
    public List<ServiceInstance> getServiceInstances(@PathVariable String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }

    /**
     * 获取服务实例
     */
    @GetMapping("/services/{serviceName}/{instanceId}")
    public ServiceInstance getServiceInstance(@PathVariable String serviceName, @PathVariable String instanceId) {
        return getServiceInstances(serviceName)
                .stream()
                .filter(serviceInstance -> serviceInstance.getInstanceId().equals(instanceId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No Such service instance"));
    }


}
