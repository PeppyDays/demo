package com.example.demo.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaceOrderCommand {

    private final String customerId;
    private final String customerName;
    private final String productNo;
    private final String productName;
    private final String currency;
    private final Integer amount;
}
