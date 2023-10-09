package com.yicj.study.webmvc.support;

import com.yicj.study.webmvc.config.AppConfig;
import com.yicj.study.webmvc.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

/**
 * @author yicj
 * @date 2023/10/9 21:33
 */
@Slf4j
@SpringJUnitWebConfig(AppConfig.class)
public class ConfigurationClassJUnitJupiterSpringWebTests {

    @Autowired
    private HelloService helloService ;

    @Test
    public void hello(){
        String name = "张三" ;
        String retValue = helloService.hello(name);
        log.info("====> ret value : {}", retValue);
    }

}
