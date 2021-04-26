package com.example.busline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.example.busline.mapper")
public class BusLineApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusLineApplication.class, args);

    }

}
