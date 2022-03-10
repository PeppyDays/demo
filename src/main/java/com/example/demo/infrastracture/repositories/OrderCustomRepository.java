package com.example.demo.infrastracture.repositories;

import com.example.demo.domain.model.aggregates.Order;

public interface OrderCustomRepository {

    Order findByOrderId(Long orderId);
}
