package org.example.controller;

import org.example.pojo.Order;
import org.example.pojo.Product;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController implements Serializable {

    @Autowired
    private OrderService orderService;

    @GetMapping("/idAndOrderNo")
    public Order selectOrderByIdAndOrderNo(Integer id,String orderNo) {

        return orderService.selectOrderByIdAndOrderNo(id,orderNo);
    }

}
