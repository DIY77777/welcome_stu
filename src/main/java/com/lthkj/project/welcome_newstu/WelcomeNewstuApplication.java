package com.lthkj.project.welcome_newstu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lthkj.project.welcome_newstu.dao")
public class WelcomeNewstuApplication {

    public static void main(String[] args) {
        SpringApplication.run(WelcomeNewstuApplication.class, args);
    }

}
