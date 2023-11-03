package com.yicj.study.webmvc.controller;

import com.yicj.study.webmvc.model.form.HelloCreateForm;
import com.yicj.study.webmvc.service.HelloService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yicj
 * @date 2023/10/9 21:13
 */
@Slf4j
@RestController
@AllArgsConstructor
public class HelloController {

//    @Autowired
    private final HelloService helloService ;

    @GetMapping("/hello/index")
    public String index(){
        String retValue = helloService.hello("张三");
        log.info("--------------> ret value : {}", retValue);
        return "hello world" ;
    }

    @PostMapping(value = "/hello/create"/*, consumes = "application/json", produces = "application/json"*/)
    public String create(@RequestBody HelloCreateForm form){
        String retValue = helloService.hello("张三");
        log.info("-----------> create name:  {}", form.getName());
        log.info("--------------> ret value : {}", retValue);
        return "hello world" ;
    }
}
