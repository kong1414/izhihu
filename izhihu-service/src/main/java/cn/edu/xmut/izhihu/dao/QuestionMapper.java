package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Question;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("QuestionDAO")
public interface QuestionMapper extends Mapper<Question> {
}