package cn.edu.xmut.izhihu.service.impl;

import cn.edu.xmut.izhihu.dao.HotListMapper;
import cn.edu.xmut.izhihu.pojo.common.ResultVO;
import cn.edu.xmut.izhihu.pojo.common.SuccessVO;
import cn.edu.xmut.izhihu.pojo.vo.HotListVO;
import cn.edu.xmut.izhihu.service.HotListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-06-27 14:43
 * @Version: 1.0
 */
@Service
public class HotListServiceImpl implements HotListService {

    @Autowired
    private HotListMapper hotListMapper;

    /**
     * 根据categoryType 列出热榜
     *
     * @param categoryType
     * @return
     */
    @Override
    public ResultVO list(int categoryType) {
        List<HotListVO> res = hotListMapper.listByCategoryType(categoryType);


        return new SuccessVO(res);
    }
}
