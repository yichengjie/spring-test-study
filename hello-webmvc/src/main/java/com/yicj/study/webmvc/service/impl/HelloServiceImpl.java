package com.yicj.study.webmvc.service.impl;

import com.yicj.study.webmvc.repository.UserRepository;
import com.yicj.study.webmvc.repository.entity.User;
import com.yicj.study.webmvc.repository.mapper.UserMapper;
import com.yicj.study.webmvc.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yicj
 * @date 2023/10/9 21:20
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private UserRepository userRepository ;

//    @Autowired
//    private UserMapper userMapper;

    @Override
    public String hello(String name) {
//        User user = userMapper.selectById(1);
//        log.info("user : {}", user);
        userRepository.hello(name) ;
        return "hello, " + name;
    }
}
