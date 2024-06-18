package com.example.calculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.example.calculator.utils.Associativity;
import com.example.calculator.utils.Precedence;

public class ExpressionEvaluator {

    private static final Map<Character, Precedence> precedenceMap = new HashMap<>();
    private static final Map<Character, Associativity> associativityMap = new HashMap<>();

    static {
        precedenceMap.put('+', Precedence.ADD_SUBTRACT);
        precedenceMap.put('-', Precedence.ADD_SUBTRACT);
        precedenceMap.put('*', Precedence.MULTIPLY_DIVIDE);
        precedenceMap.put('/', Precedence.MULTIPLY_DIVIDE);
        precedenceMap.put('^', Precedence.POWER_ROOT);
        precedenceMap.put('!', Precedence.FACTORIAL);

        associativityMap.put('+', Associativity.LEFT);
        associativityMap.put('-', Associativity.LEFT);
        associativityMap.put('*', Associativity.LEFT);
        associativityMap.put('/', Associativity.LEFT);
        associativityMap.put('^', Associativity.RIGHT);
        associativityMap.put('!', Associativity.LEFT);
    }

    public ExpressionEvaluator() {
    }

    public static int evaluatePostfix(String postfix) {
        return 0;
    }

    public static String infixToPostfix(String infix) {

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char token : infix.toCharArray()) {
            if (Character.isLetterOrDigit(token)) {
                result.append(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();  // pops (
            } else {
                while ((!stack.isEmpty() && isOperator(stack.peek())
                        && (getPrecedence(token) < getPrecedence(stack.peek())
                            || (getPrecedence(token) == getPrecedence(stack.peek())
                                && getAssociativity(token) == Associativity.LEFT)))) {
                    result.append(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static boolean isOperator(char token) {
        return precedenceMap.containsKey(token);
    }

    public static Associativity getAssociativity(char token) {
        return associativityMap.get(token);
    }

    public static int getPrecedence(char token) {
        return precedenceMap.get(token).getValue();
    }
}
