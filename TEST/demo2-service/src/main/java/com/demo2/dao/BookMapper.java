package com.demo2.dao;

import com.demo2.pojo.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BookMapper extends Mapper<Book> {

    List<Book> findByName(@Param("keyword") String keyword);
}