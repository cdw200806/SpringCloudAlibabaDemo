package org.example.service.impl;

import org.example.pojo.Product;
import org.example.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {


    @Override
    public Product selctProductById(Integer id) {
        return new Product(id, "冰箱", 1, 2666D);
    }
}
