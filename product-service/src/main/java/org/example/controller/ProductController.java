package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pojo.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements Serializable {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product selctProductById(@PathVariable("id") Integer id) {

        return productService.selctProductById(id);



    }

}
