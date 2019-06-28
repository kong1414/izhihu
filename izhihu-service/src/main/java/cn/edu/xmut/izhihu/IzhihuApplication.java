package cn.edu.xmut.izhihu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ServletComponentScan
@MapperScan(basePackages = "cn.edu.xmut.izhihu.dao")
@SpringBootApplication
public class IzhihuApplication {

    public static void main(String[] args) {
        SpringApplication.run(IzhihuApplication.class, args);
    }

}
