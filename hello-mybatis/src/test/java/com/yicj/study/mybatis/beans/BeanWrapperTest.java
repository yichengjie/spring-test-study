package com.yicj.study.mybatis.beans;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yicj
 * @date 2023/11/4 20:36
 */
@Slf4j
public class BeanWrapperTest {
    @Test
    public void hello(){
        BeanWrapper beanWrapper = new BeanWrapperImpl(MapperScannerConfigurer.class);
        List<String> propertyNames = Stream.of(beanWrapper.getPropertyDescriptors())
                .map(PropertyDescriptor::getName)
                .toList();
        log.info("propertyNames : {}", propertyNames);
    }
}
