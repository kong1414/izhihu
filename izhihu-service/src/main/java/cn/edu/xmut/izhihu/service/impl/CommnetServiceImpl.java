package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.ArticleMapper;
import cn.edu.xmut.izhihu.dao.CommentMapper;
import cn.edu.xmut.izhihu.pojo.common.HttpCodeEnum;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.Article;
import cn.edu.xmut.izhihu.pojo.entity.Comment;
import cn.edu.xmut.izhihu.pojo.request.CommentRequest;
import cn.edu.xmut.izhihu.service.CommnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-03 23:17
 * @Version: 1.0
 */
@Service
@Transactional
public class CommnetServiceImpl implements CommnetService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

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
    public synchronized ResultVO comment(CommentRequest record) {
        Comment comment = new Comment();
        comment.setCommentId(record.getCommentId());
        comment.setIsReply(record.getIsReply());
        comment.setReplyId(record.getReplyId());
        comment.setCommentatorId(record.getCommentatorId());
        comment.setCommentContent(record.getCommentContent());
        commentMapper.insertSelective(comment);

        Article article = articleMapper.selectByPrimaryKey(record.getCommentId());
        if (article != null) {
            article.setCommentNum(article.getCommentNum() + 1);
        }


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
    public synchronized ResultVO delete(String userId, String id) {
        Comment record = commentMapper.selectByPrimaryKey(id);
        if (userId.equals(record.getCommentatorId())) {
            record.setDel(1);
            commentMapper.updateByPrimaryKeySelective(record);

            Article article = articleMapper.selectByPrimaryKey(record.getCommentId());
            if (article != null) {
                article.setCommentNum(article.getCommentNum() - 1);
            }

            return new SuccessVO("删除成功");
        } else {
            return new ResultVO(HttpCodeEnum.REQUEST_FAIL.getCode(), null, "不能删除别人的评论哦");
        }
    }
}
