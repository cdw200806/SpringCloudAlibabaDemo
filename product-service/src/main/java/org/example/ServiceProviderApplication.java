package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//约定大于配置，只要依赖添加了eureka.默认开启。。。 grange之前需要添加client。
//@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceProviderApplication.class, args);
    }

}
