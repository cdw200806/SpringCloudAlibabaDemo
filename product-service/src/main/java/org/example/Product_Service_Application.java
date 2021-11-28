package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//约定大于配置，只要依赖添加了eureka.默认开启。。。 grange之前需要添加client。
//@EnableDiscoveryClient
@SpringBootApplication
public class Product_Service_Application {

    public static void main(String[] args) {

        SpringApplication.run(Product_Service_Application.class, args);
    }

}
