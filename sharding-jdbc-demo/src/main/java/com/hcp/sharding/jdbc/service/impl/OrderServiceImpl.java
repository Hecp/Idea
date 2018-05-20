package com.hcp.sharding.jdbc.service.impl;

import com.hcp.sharding.jdbc.domain.Order;
import com.hcp.sharding.jdbc.repository.OrderRepository;
import com.hcp.sharding.jdbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hcp on 2018/5/19.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void test() {
        Order order;
        Long orderId;
        for (int i = 0; i < 10; i++) {
            order = new Order();
            order.setUserId(519L);
            orderId = orderRepository.save(order).getOrderId();
            System.out.println("orderId = " + orderId);
        }
    }
}
