package com.yicj.study.webmvc.service;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.yicj.study.webmvc.repository.UserRepository;
import com.yicj.study.webmvc.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author yicj
 * @date 2023年11月03日 14:52
 */
@Slf4j
@MybatisPlusTest
//@SpringJUnitConfig
@Import({UserRepository.class, HelloServiceImpl.class})
public class HelloServiceTest {

    @Autowired
    private HelloService helloService ;
      // 如果存在静态内部类，这里必须得手动配置@MapperScan,否则会报错
//    @Configuration
//    static class Config {
//
//    }

    @Test
    public void hello(){
        String retValue = helloService.hello("张三");
        log.info("ret value : {}", retValue);
    }

}
