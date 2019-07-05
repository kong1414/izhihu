package com.demo2.dao;

import com.demo2.pojo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    @Select("select * from user where username = #{name}")
    User findByName(@Param("name") String name);
}