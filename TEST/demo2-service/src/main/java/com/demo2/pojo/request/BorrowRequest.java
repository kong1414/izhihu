package com.demo2.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-05 14:40
 * @Version: 1.0
 */
@Data
public class BorrowRequest {
    private int userId;
    private int bookId;
}
