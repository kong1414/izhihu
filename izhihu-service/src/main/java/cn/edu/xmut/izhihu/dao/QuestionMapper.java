package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository("QuestionDAO")
public interface QuestionMapper extends Mapper<Question> {

    List<Map<String, Object>> findAnsByQues(@Param("quesId") String quesId);
}