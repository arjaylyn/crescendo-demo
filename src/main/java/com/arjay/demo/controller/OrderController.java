package com.arjay.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.arjay.demo.entity.Order;
import com.arjay.demo.services.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class OrderController {

    @Autowired
    private IOrderService orderServ;
    
    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderServ.getOrderById(id);
    }
    
}
