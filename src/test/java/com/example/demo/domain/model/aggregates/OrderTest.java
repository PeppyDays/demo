package com.example.demo.domain.model.aggregates;

import com.example.demo.domain.model.commands.PlaceOrderCommand;
import com.example.demo.domain.model.repositories.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    @Commit
    @DisplayName("1개 주문을 실제 사용중인 데이터베이스에 저장한다.")
    void testSavingOrder() {

        PlaceOrderCommand command = new PlaceOrderCommand(
                "youdongk",
                "Dongkyun",
                "C-001",
                "Cozy couch",
                "KRW",
                735000
        );
        Order order = new Order(command);
        orderRepository.save(order);
    }

    @Test
    @DisplayName("1개 주문을 실제 사용중인 데이터베이스에서 불러온다.")
    void testLoadingOrder() {

        Order order = orderRepository.findByOrderId(1L);
        System.out.println(order);
    }

    @Test
    @Transactional
    @Commit
    @DisplayName("1개 주문을 완료 처리해서 상태를 성공으로 변경한다.")
    void testCompletingOrder() {

        Order order = orderRepository.findByOrderId(1L);
        order.completeOrder();
    }
}
