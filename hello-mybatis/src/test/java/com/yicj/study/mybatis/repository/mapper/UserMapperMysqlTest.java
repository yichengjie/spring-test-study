package com.yicj.study.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.yicj.study.mybatis.repository.entity.UserEntity;
import com.yicj.study.mybatis.utils.ContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;


@Slf4j
@MybatisPlusTest
// Replace.NONE 表示使用线上数据库
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperMysqlTest {

    @Autowired
    private UserMapper userMapper ;

    @Autowired
    private ApplicationContext context ;

    @Test
    public void list4Page(){
        String name = "王五" ;
        IPage<UserEntity> pageParam = new Page<>(1, 2) ;
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>() ;
        queryWrapper.like(UserEntity::getName, name) ;
        IPage<UserEntity> page = userMapper.selectPage(pageParam, queryWrapper);
        page.getRecords().forEach(item -> log.info("item -> {}", item));
        //
        ContextUtils.printlnBeansClassName(context);
    }

    @Test
    @Rollback(false)
    public void save(){
        String name = "王五22" ;
        UserEntity entity = new UserEntity() ;
        entity.setName(name) ;
        entity.setJob("job 22") ;
        entity.setCompany("company 22") ;
        userMapper.insert(entity) ;
    }
}