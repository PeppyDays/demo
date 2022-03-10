package com.example.demo.domain.model.repositories;

import com.example.demo.domain.model.aggregates.Order;
import com.example.demo.infrastracture.repositories.OrderCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, OrderCustomRepository {

}
