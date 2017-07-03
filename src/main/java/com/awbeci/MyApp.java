package com.awbeci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({"com.awbeci","com.hellozw"})
public class MyApp {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MyApp.class,args);
    }
}
