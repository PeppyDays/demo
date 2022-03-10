package com.example.demo.domain.model.valueobjects;

import lombok.Getter;

import com.google.common.collect.ImmutableMap;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Status {

    PROGRESS("P"),
    SUCCESS("S"),
    FAIL("F");

    private static final ImmutableMap<String, Status> codes = ImmutableMap.copyOf(
            Stream.of(values()).collect(Collectors.toMap(Status::getValue, Function.identity()))
    );

    @Getter
    private final String value;

    Status(String value) {
        this.value = value;
    }

    public static Status find(final String value) {
        return codes.get(value);
    }
}
