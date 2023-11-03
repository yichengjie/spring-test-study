package com.yicj.study.webmvc.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yicj
 * @date 2023年11月03日 11:25
 */
@Data
@TableName("`student`")
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
