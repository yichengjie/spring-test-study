package com.yicj.study.webmvc.config;

import com.yicj.study.webmvc.repository.UserRepository;
import com.yicj.study.webmvc.service.HelloService;
import com.yicj.study.webmvc.service.impl.HelloServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yicj
 * @date 2023/10/9 21:15
 */
@Configuration
@MapperScan("com.yicj.study.webmvc.repository.mapper")
public class AppConfig {

}
