package com.demo2.controller;

import com.demo2.dao.BookMapper;
import com.demo2.dao.RecordMapper;
import com.demo2.pojo.common.ResultVO;
import com.demo2.pojo.common.SuccessVO;
import com.demo2.pojo.entity.Book;
import com.demo2.pojo.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-05 14:10
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RecordMapper recordMapper;


    @PostMapping("/list")
    private ResultVO list(@RequestParam(defaultValue = "") String keyword) {
        if ("".equals(keyword)) {
            return new SuccessVO(bookMapper.selectAll());
        } else {
            return new SuccessVO(bookMapper.findByName(keyword));
        }
    }

    @PostMapping("/create")
    private ResultVO create(Book book) {
        bookMapper.insert(book);
        return new SuccessVO("新增成功");
    }

    @PostMapping("/updata")
    private ResultVO updata(Book book) {
        bookMapper.updateByPrimaryKey(book);
        return new SuccessVO("更新成功");
    }

    @PostMapping("/del")
    private ResultVO del(int id) {

        Record record = new Record();
        record.setBookId(id);

        List<Record> list = recordMapper.select(record);

        if (list.size() > 0) {
            return new ResultVO(400, null, "有记录无法删除");
        }
        bookMapper.deleteByPrimaryKey(id);
        return new SuccessVO("删除成功");
    }


}
