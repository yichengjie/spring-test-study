package com.yicj.study.webmvc.repository;

import org.springframework.stereotype.Component;

/**
 * @author yicj
 * @date 2023年11月01日 14:59
 */
@Component
public class UserRepository {

    public String hello(String name){

        return "hello, " + name ;
    }

}
