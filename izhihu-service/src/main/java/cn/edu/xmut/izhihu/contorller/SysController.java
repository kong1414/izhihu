package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-10 10:29
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;
}
