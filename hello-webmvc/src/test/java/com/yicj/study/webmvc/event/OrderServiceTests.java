package com.yicj.study.webmvc.event;

import com.yicj.study.webmvc.config.AppConfig;
import com.yicj.study.webmvc.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yicj
 * @date 2023/10/9 21:49
 */
@Slf4j
@SpringJUnitConfig(AppConfig.class)
@RecordApplicationEvents
class OrderServiceTests {

    @Autowired
    private HelloService helloService;

    @Autowired
    private ApplicationEvents events ;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void apx(){
        log.info("info : {}", applicationContext);
    }

    @Test
    void submitOrder() {
        // Invoke method in OrderService that publishes an event
        String name = "张三" ;
        String retValue = helloService.hello(name);
        log.info("ret value : {}", retValue);
        // Verify that an OrderSubmitted event was published
        Long numEvents = events.stream(OrderSubmitted.class).count();
        assertThat(numEvents).isEqualTo(1L);
    }
}