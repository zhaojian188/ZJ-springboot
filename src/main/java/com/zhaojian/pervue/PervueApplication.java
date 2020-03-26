package com.zhaojian.pervue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  //开启mysql事务
public class PervueApplication {

    public static void main(String[] args) {
        SpringApplication.run(PervueApplication.class, args);
    }

}
