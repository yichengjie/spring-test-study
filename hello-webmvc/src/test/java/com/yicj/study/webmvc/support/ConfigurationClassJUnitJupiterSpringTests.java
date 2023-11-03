package com.yicj.study.webmvc.support;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.yicj.study.webmvc.config.AppConfig;
import com.yicj.study.webmvc.repository.UserRepository;
import com.yicj.study.webmvc.service.HelloService;
import com.yicj.study.webmvc.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

/**
 * @author yicj
 * @date 2023/10/9 21:18
 */
@Slf4j
@Import({UserRepository.class, HelloServiceImpl.class})
@MybatisPlusTest
public class ConfigurationClassJUnitJupiterSpringTests {

    @Autowired
    private HelloService helloService ;

    @Test
    public void hello(){
        String name = "张三" ;
        String retValue = helloService.hello(name);
        log.info("====> ret value : {}", retValue);
    }

}
