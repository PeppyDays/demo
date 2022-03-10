package com.example.demo.infrastracture.repositories;

import com.example.demo.domain.model.aggregates.Order;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static com.example.demo.domain.model.aggregates.QOrder.order;

@Repository
public class OrderCustomerRepositoryImpl implements OrderCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public OrderCustomerRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Order findByOrderId(Long orderId) {
        return jpaQueryFactory
                .selectFrom(order)
                .where(order.orderId.eq(orderId))
                .fetchFirst();
    }
}
