package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository("UsersDAO")
public interface UsersMapper extends Mapper<UserDO> {

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

    List<Map<String, Object>> getUserInfo(@Param("userId") String userId);
}