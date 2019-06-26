package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.CommentDO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-26 20:23
 * @Version: 1.0
 */
@Repository
public interface CommentMapper extends Mapper<CommentDO> {
}