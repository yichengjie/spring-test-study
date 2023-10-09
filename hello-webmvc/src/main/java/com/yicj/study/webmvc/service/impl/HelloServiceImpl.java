package com.yicj.study.webmvc.service.impl;

import com.yicj.study.webmvc.service.HelloService;

/**
 * @author yicj
 * @date 2023/10/9 21:20
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello, " + name;
    }
}
