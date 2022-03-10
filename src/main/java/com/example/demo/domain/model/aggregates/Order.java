package com.example.demo.domain.model.aggregates;

import com.example.demo.domain.model.valueobjects.Customer;
import com.example.demo.domain.model.valueobjects.OrderItem;
import com.example.demo.domain.model.valueobjects.Status;
import com.example.demo.domain.model.valueobjects.StatusConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
public class Order extends AbstractAggregateRoot<Order> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Embedded
    private Customer customer;

    @Column(name = "status")
    @Convert(converter = StatusConverter.class)
    private Status status;

    @ElementCollection
    @CollectionTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    @OrderColumn(name = "line_no")
    private List<OrderItem> orderItems;

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "last_modified_at", updatable = false)
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
}
