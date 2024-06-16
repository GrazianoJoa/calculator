package com.example.calculator;

import com.example.calculator.model.ExpressionEvaluator;

public class Main {

    public static void main(String[] args) {
        System.out.println(ExpressionEvaluator.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
    
}
