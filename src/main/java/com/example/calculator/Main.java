package com.example.calculator;

import com.example.calculator.model.ExpressionEvaluator;

public class Main {

    public static void main(String[] args) {
        System.out.println(ExpressionEvaluator.infixToPostfix("a^(1/3)"));
    }
    
}
