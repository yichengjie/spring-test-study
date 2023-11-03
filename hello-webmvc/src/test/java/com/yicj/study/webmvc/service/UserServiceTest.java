package com.yicj.study.webmvc.service;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.yicj.study.webmvc.repository.entity.User;
import com.yicj.study.webmvc.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;

/**
 * @author yicj
 * @date 2023年11月03日 14:24
 */
@Slf4j
@MybatisPlusTest
@Import(UserServiceImpl.class)
public class UserServiceTest {

    @Autowired
    private UserService userService ;

    @Test
    public void listAll(){
        List<User> list = userService.list();
        log.info("list size : {}", list.size());
        list.forEach(item -> log.info("item -> {}", item));
    }

}
