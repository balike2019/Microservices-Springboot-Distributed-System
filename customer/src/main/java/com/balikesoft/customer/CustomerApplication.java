package com.balikesoft.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan,@EnableAutoConfiguratio,@SpringBootConfiguration
public class CustomerApplication {
    public static void main(String[]args){

        SpringApplication.run(CustomerApplication.class,args);
    }
}
