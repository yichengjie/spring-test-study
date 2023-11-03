package com.yicj.study.webmvc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicj.study.webmvc.repository.entity.User;
import com.yicj.study.webmvc.repository.mapper.UserMapper;
import com.yicj.study.webmvc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author yicj
 * @date 2023年11月03日 14:23
 */
@Service
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User> implements UserService {

}
