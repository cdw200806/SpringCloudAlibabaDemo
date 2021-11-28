package org.example.service;

import org.example.pojo.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {


    Product selctProductById(Integer id);

}
