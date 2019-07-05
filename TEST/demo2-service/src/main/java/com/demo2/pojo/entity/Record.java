package com.demo2.pojo.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 借阅时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 归还时间
     */
    @Column(name = "return_time")
    private Date returnTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return book_id
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * @param bookId
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取借阅时间
     *
     * @return create_time - 借阅时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置借阅时间
     *
     * @param createTime 借阅时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取归还时间
     *
     * @return return_time - 归还时间
     */
    public Date getReturnTime() {
        return returnTime;
    }

    /**
     * 设置归还时间
     *
     * @param returnTime 归还时间
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
}