package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.UserDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("UsersDAO")
public interface UsersMapper extends Mapper<UserDO> {

    @Select("select * from users where phone = #{account} or email  = #{account}")
    public UserDO getUserDOByAccount(String account);
}