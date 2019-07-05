package com.demo2.dao;

import com.demo2.pojo.entity.Record;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface RecordMapper extends Mapper<Record> {
}