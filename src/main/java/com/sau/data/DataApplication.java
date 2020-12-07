package com.sau.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 18:28 2020/12/7
 * @Modified By:
 */
@SpringBootApplication
@MapperScan("com.sau.data.dao")
public class DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }
}
