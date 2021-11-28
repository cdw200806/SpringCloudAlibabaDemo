package org.example.service;

import org.example.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("product-service")
public interface ProductService {

    @GetMapping("/product/{id}")
    Product selctProductById(@PathVariable("id") Integer id);

}
