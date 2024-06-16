package com.example.calculator.model;

import java.util.Stack;

public class ExpressionEvaluator {

    public ExpressionEvaluator() {
    }

    public static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '(' from the stack
            } else { // c is an operator
                while (!stack.isEmpty() && getPrecedenceScore(c) <= getPrecedenceScore(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators left in the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int getPrecedenceScore(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static char associativity(char c) {
        return (c == '^') ? 'R' : 'L';
    }

    public static boolean operatorPrecedenceCondition(char currentOp, char topOfStack) {
        int precedenceCurrent = getPrecedenceScore(currentOp);
        int precedenceTop = getPrecedenceScore(topOfStack);

        if (precedenceCurrent != precedenceTop) {
            return precedenceCurrent < precedenceTop;
        } else {
            // Same precedence, check associativity
            return associativity(currentOp) == 'L';
        }
    }
}
