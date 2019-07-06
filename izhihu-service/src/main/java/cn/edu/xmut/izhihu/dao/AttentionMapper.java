package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Attention;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("AttentionDAO")
public interface AttentionMapper extends Mapper<Attention> {
    /**
     * 求出有多少个关注某一事物
     *
     * @param attId
     * @return
     */
    int countByAttId(@Param("attId") String attId);
}