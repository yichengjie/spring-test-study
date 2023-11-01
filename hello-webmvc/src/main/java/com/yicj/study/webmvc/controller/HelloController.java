package com.yicj.study.webmvc.controller;

import com.yicj.study.webmvc.model.form.HelloCreateForm;
import com.yicj.study.webmvc.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yicj
 * @date 2023/10/9 21:13
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService ;

    @GetMapping("/index")
    public String index(){
        String retValue = helloService.hello("张三");
        log.info("--------------> ret value : {}", retValue);
        return "hello world" ;
    }

    @PostMapping("/create")
    public String create(@RequestBody HelloCreateForm form){
        String retValue = helloService.hello("张三");
        log.info("-----------> create name:  {}", form.getName());
        log.info("--------------> ret value : {}", retValue);
        return "hello world" ;
    }
}
