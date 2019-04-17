package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.jk.mapper")
@ComponentScan("com.jk.*")
public class Appintlication {

    public static void main(String[] args) {
        SpringApplication.run(Appintlication.class, args);
    }

}
