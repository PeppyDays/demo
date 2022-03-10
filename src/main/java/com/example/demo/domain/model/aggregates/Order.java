package com.example.demo.domain.model.aggregates;

import com.example.demo.domain.model.commands.PlaceOrderCommand;
import com.example.demo.domain.model.valueobjects.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@ToString
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
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "last_modified_at", updatable = false)
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    public Order(PlaceOrderCommand command) {
        this.customer = new Customer(command.getCustomerId(), command.getCustomerName());
        this.status = Status.PROGRESS;
        this.orderItems.add(
                new OrderItem(
                        new Product(command.getProductNo(), command.getProductName()),
                        new Money(command.getCurrency(), command.getAmount())
                )
        );
    }

    public void completeOrder() {
        try {
            this.status = Status.SUCCESS;
        } catch(Exception e) {
            this.status = Status.FAIL;
            throw e;
        }
    }
}
