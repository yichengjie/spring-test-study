package com.yicj.study.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.yicj.study.mybatis.repository.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;


@Slf4j
@MybatisPlusTest
// Replace.NONE 表示使用线上数据库
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql({"classpath:sql/DDL_init.sql", "classpath:sql/DML_init.sql"})
class UserMapperTest {

    @Autowired
    private UserMapper userMapper ;

    @Test
    public void list4Page(){
        String name = "王五" ;
        IPage<UserEntity> pageParam = new Page<>(1, 2) ;
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>() ;
        queryWrapper.like(UserEntity::getName, name) ;
        IPage<UserEntity> page = userMapper.selectPage(pageParam, queryWrapper);
        page.getRecords().forEach(item -> log.info("item -> {}", item));
    }
}