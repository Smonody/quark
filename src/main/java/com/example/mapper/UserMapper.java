package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: UserMapper
 * @description: TODO 类描述
 * @author: lemdeng
 * @date: 2022/2/16
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
