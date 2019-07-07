package cn.edu.xmut.izhihu.pojo.request;

import lombok.Data;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-07 22:20
 * @Version: 1.0
 */
@Data
public class UpdateUserInfoRequest {
    private String userId;
    private String name;
    private String photoUrl;

    private int gender;
    private String autograph;
    private String introduce;
    private String industry;
    private String personalityUrl;
    private String company;
    private String position;
    private String school;
    private String major;

}
