package com.arjay.demo.services;

import com.arjay.demo.entity.Order;

public interface IOrderService {

    Order getOrderById(Long id);
}
