package com.yicj.study.webmvc.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yicj.study.webmvc.repository.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yicj
 * @date 2023年11月01日 15:14
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
