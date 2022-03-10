package com.example.demo.domain.model.valueobjects;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Column(name = "product_no")
    private String productNo;

    @Column(name = "product_name")
    private String productName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productNo.equals(product.productNo) && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, productName);
    }
}
