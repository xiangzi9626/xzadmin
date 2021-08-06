package com.example.xzadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@MapperScan("com.example.xzadmin.mapper")
public class XzadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(XzadminApplication.class, args);
    }

}
