package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pojo.Order;
import org.example.pojo.Product;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public interface OrderService {

//写三种 service   元数据      Ribbon   Ribbon注解
  Order selectOrderByIdAndOrderNo(Integer id,String orderNo);

}
