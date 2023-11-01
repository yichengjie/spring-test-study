package com.yicj.study.webmvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yicj
 * @date 2023/10/9 21:12
 */
@SpringBootApplication
@MapperScan("com.yicj.study.webmvc.repository.mapper")
public class WebMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMvcApplication.class, args) ;
    }
}
