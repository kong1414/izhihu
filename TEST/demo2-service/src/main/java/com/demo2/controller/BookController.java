package com.demo2.controller;

import com.demo2.dao.BookMapper;
import com.demo2.dao.RecordMapper;
import com.demo2.pojo.common.ResultVO;
import com.demo2.pojo.common.SuccessVO;
import com.demo2.pojo.entity.Book;
import com.demo2.pojo.entity.Record;
import com.demo2.pojo.request.BorrowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-05 14:10
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/book")
@Transactional
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RecordMapper recordMapper;


    @PostMapping("/list")
    public ResultVO list(@RequestParam(defaultValue = "",required = false) String keyword) {
        if ("".equals(keyword)) {
            return new SuccessVO(bookMapper.selectAll());
        } else {
            return new SuccessVO(bookMapper.findByName(keyword));
        }
    }

    @PostMapping("/create")
    public ResultVO create(@RequestBody Book book) {
        bookMapper.insert(book);
        return new SuccessVO("新增成功");
    }

    @PostMapping("/update")
    public ResultVO update(@RequestBody Book book) {
        bookMapper.updateByPrimaryKey(book);
        return new SuccessVO("更新成功");
    }

    @PostMapping("/del")
    public ResultVO del(@RequestParam("id") int id) {
        Record record = new Record();
        record.setBookId(id);
        List<Record> list = recordMapper.select(record);
        if (list.size() > 0) {
            return new ResultVO(400, null, "有记录无法删除");
        }
        bookMapper.deleteByPrimaryKey(id);
        return new SuccessVO("删除成功");
    }


    @PostMapping("/borrow")
    public synchronized ResultVO borrow(@RequestBody BorrowRequest record) {

        // Record rea = new Record();
        //
        // rea.setBookId(record.getBookId());
        // rea.setUserId(record.getUserId());
        //
        // List<Record> relist = recordMapper.select(rea);
        // if (relist.size() >= 0) {
        //     return new ResultVO(400, null, "已借阅");
        // }


        int bookid = record.getBookId();
        Book book = bookMapper.selectByPrimaryKey(bookid);
        if (book.getStock() <= 0) {
            return new ResultVO(400, null, "库存不足");
        }

        book.setStock(book.getStock() - 1);
        bookMapper.updateByPrimaryKey(book);


        Record re = new Record();
        re.setBookId(record.getBookId());
        re.setUserId(record.getUserId());
        recordMapper.insertSelective(re);


        return new SuccessVO("借阅成功");
    }

    @PostMapping("/rebook")
    public ResultVO rebook(@RequestParam("id") int id) {
        Record red = recordMapper.selectByPrimaryKey(id);
        red.setReturnTime(new Date());
        recordMapper.updateByPrimaryKey(red);
        return new SuccessVO("归还成功");
    }

    @PostMapping("/myRecordList")
    public ResultVO recordList(@RequestParam("userId") int userId) {
        return new SuccessVO(bookMapper.findRecordById(userId));
    }

    @PostMapping("/recordAllList")
    public ResultVO RecordAllList(@RequestParam(defaultValue = "",required = false) String keyword) {
        if ("".equals(keyword)) {
            return new SuccessVO(bookMapper.selectAll());
        } else {
            return new SuccessVO(bookMapper.findAllRecord(keyword));
        }
    }
}
