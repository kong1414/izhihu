package cn.edu.xmut.izhihu.contorller;

import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.request.MessSendRequest;
import cn.edu.xmut.izhihu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-09 13:58
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/list")
    public ResultVO list(@RequestParam String userId){

        return messageService.list(userId);
    }

    @PostMapping("/read")
    public ResultVO read(@RequestParam String id){

        return messageService.read(id);
    }
    @PostMapping("/del")
    public ResultVO del(@RequestParam String id){

        return messageService.del(id);
    }
    @PostMapping("/send")
    public ResultVO send(@RequestBody MessSendRequest record){

        return messageService.send(record);
    }

}
