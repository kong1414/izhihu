package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.Comment;
import cn.edu.xmut.izhihu.pojo.vo.CommentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("CommentDAO")
public interface CommentMapper extends Mapper<Comment> {

    /**
     * 查看某个内容的评论
     *
     * @param contentId
     * @return
     */
    public List<CommentVO> findByContentId(@Param("contentId") String contentId);
}