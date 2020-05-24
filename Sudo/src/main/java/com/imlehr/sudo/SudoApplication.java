package com.imlehr.sudo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Lehr
 * @create: 2020-04-10
 */
@SpringBootApplication
@ComponentScan("com.imlehr")
@MapperScan("com.imlehr.sudo.dao")
public class SudoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SudoApplication.class,args);
    }
}
