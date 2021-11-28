package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pojo.Product;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public interface ProductService {


    Product selctProductById(Integer id);

}
