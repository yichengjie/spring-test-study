package com.yicj.study.webmvc.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public class ContextUtils {
    /**
     * 打印出 容器中的 bean 的类名
     * @param context spring
     */
    public static void printlnBeansClassName(ApplicationContext context) {
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            log.info("name : {}", context.getBean(definitionName).getClass().getName());
        }

        log.info("names count = {}", definitionNames.length);
    }
}
