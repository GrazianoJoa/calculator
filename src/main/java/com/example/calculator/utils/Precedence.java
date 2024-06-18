package com.example.calculator.utils;

public enum Precedence {
    ADD_SUBTRACT(1),
    MULTIPLY_DIVIDE(2),
    POWER_ROOT(3),
    FACTORIAL(4);

    private final int value;

    Precedence(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
