package com.kevin.eureka.server.sample;

import org.junit.jupiter.api.Test;

/**
 * 系统配置
 *
 * @author wangyong
 */
public class SysPropTest {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
        System.out.println(Integer.getInteger("user.count", 1));
        System.out.println(Boolean.getBoolean("user.flag"));
    }

    @Test
    public void sysPropTest() {
        System.out.println(System.getProperty("user.home"));
        System.out.println(Integer.getInteger("user.count", 1));
    }
}
