package cn.edu.xmut.izhihu.dao;

import cn.edu.xmut.izhihu.pojo.entity.HotList;
import cn.edu.xmut.izhihu.pojo.vo.HotListVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("HotListDAO")
public interface HotListMapper extends Mapper<HotList> {

    /**
     * 根据 categoryType 查出热榜
     *
     * @param categoryType
     * @return
     */
    public List<HotListVO> listByCategoryType(@Param("categoryType") int categoryType);
}