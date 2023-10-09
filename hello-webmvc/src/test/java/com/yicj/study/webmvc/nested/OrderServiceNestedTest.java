package com.yicj.study.webmvc.nested;

import com.yicj.study.webmvc.service.HelloService;
import com.yicj.study.webmvc.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author yicj
 * @date 2023/10/9 22:07
 */
@Slf4j
@SpringJUnitConfig
public class OrderServiceNestedTest {

    @Configuration
    static class Config {
        // this bean will be injected into the OrderServiceTest class
        @Bean
        HelloService orderService() {
            HelloService orderService = new HelloServiceImpl();
            // set properties, etc.
            return orderService;
        }
    }

    @Autowired
    HelloService orderService;

    @Test
    void testOrderService() {
        // test the orderService
        String name = "张三" ;
        String retValue = orderService.hello(name);
        log.info("ret value : {}", retValue);
    }
}
