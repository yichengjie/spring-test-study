package com.yicj.study.webmvc.nested;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.yicj.study.webmvc.repository.UserRepository;
import com.yicj.study.webmvc.repository.mapper.UserMapper;
import com.yicj.study.webmvc.service.HelloService;
import com.yicj.study.webmvc.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yicj
 * @date 2023/10/9 22:07
 */
@Slf4j
@MybatisPlusTest
public class OrderServiceNestedTest {

    @Autowired
    HelloService helloService;

    @Configuration
    // 如果是内部类，这里需要手动添加注解@MapperScan
    @MapperScan("com.yicj.study.webmvc.repository.mapper")
    static class Config {
        @Bean
        HelloService helloService(UserRepository userRepository, UserMapper userMapper) {
            return new HelloServiceImpl();
        }
        @Bean
        UserRepository userRepository(){
            return new UserRepository() ;
        }
    }

    @Test
    void testOrderService() {
        // test the orderService
        String name = "张三" ;
        String retValue = helloService.hello(name);
        log.info("ret value : {}", retValue);
    }
}
