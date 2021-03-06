package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//激活注册中心
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication02 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServerApplication02.class,args);
    }

}
