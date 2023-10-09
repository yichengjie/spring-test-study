package com.yicj.study.webmvc.config;

import com.yicj.study.webmvc.service.HelloService;
import com.yicj.study.webmvc.service.impl.HelloServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yicj
 * @date 2023/10/9 21:15
 */
@Configuration
public class AppConfig {

    @Bean
    public HelloService helloService(){

        return new HelloServiceImpl() ;
    }
}
