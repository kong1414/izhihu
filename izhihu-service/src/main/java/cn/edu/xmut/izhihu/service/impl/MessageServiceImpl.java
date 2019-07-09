package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.PrivateMessageMapper;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.entity.PrivateMessage;
import cn.edu.xmut.izhihu.pojo.request.MessSendRequest;
import cn.edu.xmut.izhihu.service.MessageService;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-09 13:59
 * @Version: 1.0
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private PrivateMessageMapper privateMessageMapper;


    /**
     * 获取私信信息
     *
     * @param userId
     * @return
     */
    @Override
    public ResultVO list(String userId) {
        List<Map<String,Object>> list = privateMessageMapper.list(userId);
        return new SuccessVO(list);
    }

    /**
     * 发送私信
     *
     * @return
     */
    @Override
    public ResultVO send(MessSendRequest record) {

        PrivateMessage privateMessage = new PrivateMessage();
        privateMessage.setPrivMessId(IdUtil.randomUUID());

        privateMessage.setSendUserId(record.getSendUserId());
        privateMessage.setTakeinUserId(record.getTakeinUserId());
        privateMessage.setPrivMessContent(record.getContent());

        privateMessageMapper.insertSelective(privateMessage);
        return new SuccessVO("发送成功");
    }

    /**
     * 删除私信
     *
     * @param id
     * @return
     */
    @Override
    public synchronized ResultVO del(String id) {
        PrivateMessage record = privateMessageMapper.selectByPrimaryKey(id);
        record.setDel(1);
        privateMessageMapper.updateByPrimaryKeySelective(record);
        return new SuccessVO("删除成功");
    }

    /**
     * 已读
     *
     * @param id
     * @return
     */
    @Override
    public synchronized ResultVO read(String id) {
        PrivateMessage record = privateMessageMapper.selectByPrimaryKey(id);
        record.setReaded(1);
        privateMessageMapper.updateByPrimaryKeySelective(record);
        return new SuccessVO("已读");
    }
}
