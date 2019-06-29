package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("UsersDAO")
public interface UsersMapper extends Mapper<UserDO> {

    /**
     * 根据邮箱手机号查找用户
     *
     * @param account
     * @return
     */
    @Select("select * from users where phone = #{account} or email  = #{account}")
    UserDO getUserDOByAccount(String account);

    /**
     * 设置token失效
     *
     * @param id
     * @return
     */
    int updateTokenDisabled(String id);

    /**
     * 检查是否存在重复的
     * 用户名手机号邮箱
     *
     * @param account
     * @return
     */
    Integer checkRepeat(@Param("account") String account);
}