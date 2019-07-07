package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.CommentMapper;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.Comment;
import cn.edu.xmut.izhihu.pojo.request.CommentRequest;
import cn.edu.xmut.izhihu.service.CommnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-03 23:17
 * @Version: 1.0
 */
@Service
public class CommnetServiceImpl implements CommnetService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 获取某内容的评论
     *
     * @param contentId
     * @return
     */
    @Override
    public List<Map<String, Object>> find(String contentId) {
        return commentMapper.findByContentId(contentId);
    }

    /**
     * 进行评论
     *
     * @param record
     * @return
     */
    @Override
    public ResultVO comment(CommentRequest record) {
        Comment comment = new Comment();
        comment.setCommentId(record.getCommentId());
        comment.setIsReply(record.getIsReply());
        comment.setReplyId(record.getReplyId());
        comment.setCommentatorId(record.getCommentatorId());
        comment.setCommentContent(record.getCommentContent());
        commentMapper.insertSelective(comment);
        return new SuccessVO("评论成功");
    }

    /**
     * 删除评论
     *
     * @param userId
     * @param id
     * @return
     */
    @Override
    public ResultVO delete(String userId, String id) {
        Comment record = commentMapper.selectByPrimaryKey(id);
        if (record.getCommentatorId() == userId) {
            record.setDel(1);
            commentMapper.updateByPrimaryKeySelective(record);
            return new SuccessVO("删除成功");
        } else {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "不能删除别人的评论哦");
        }
    }
}
