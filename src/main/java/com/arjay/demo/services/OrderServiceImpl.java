package com.arjay.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arjay.demo.entity.Order;
import com.arjay.demo.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
    
    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> orderOpt = orderRepo.findById(id);

        if(orderOpt.isPresent()) {
            Order order = orderOpt.get();
            // order.setDetails(orderDetailRepo.findByOrder_Id(order.getId()));
            return order;
        }

        return null;
    }
}
