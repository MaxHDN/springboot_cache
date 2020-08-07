package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// 测试基于Api实现的springboot缓存，不需    要@EnableCaching注解开启缓存，在测试时，可注释掉
@EnableCaching // 开启Springboot基于注解的缓存管理
@SpringBootApplication
public class SpringbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheApplication.class, args);
    }

}
