package com.example.demo.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Embedded
    private Product product;

    @Embedded
    private Money amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return product.equals(orderItem.product) && amount.equals(orderItem.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, amount);
    }
}
