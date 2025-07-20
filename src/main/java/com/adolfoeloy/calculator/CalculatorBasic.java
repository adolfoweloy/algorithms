package com.adolfoeloy.calculator;

import java.util.Stack;

import static com.adolfoeloy.calculator.CalculatorBasic.Operator.*;

public class CalculatorBasic {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        var expression = s.concat("@"); // dumb character
        var currentNumber = 0;
        var lastOperator = ADD; // default operator
        var stack = new Stack<Integer>();

        for (char c : expression.toCharArray()) {
            if (c == ' ') {
                continue; // skip spaces
            }
            var token = new Token(String.valueOf(c));
            if (token.isNumber()) {
                currentNumber = currentNumber * 10 + token.toNumber();
            } else {
                switch (lastOperator) {
                    case ADD -> stack.push(currentNumber);
                    case SUBTRACT -> stack.push(-currentNumber);
                    case MULTIPLY -> stack.push(stack.pop() * currentNumber);
                    case DIVIDE -> stack.push(stack.pop() / currentNumber);
                }
                lastOperator = token.isOperator() ? token.toOperator() : ADD; // default to ADD if not an operator
                currentNumber = 0; // reset for next number
            }
        }

        var result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    record Token(String value) {
        boolean isOperator() {
            return "+-*/".contains(value);
        }

        boolean isNumber() {
            return value.matches("\\d+");
        }

        int toNumber() {
            return Integer.parseInt(value);
        }

        Operator toOperator() {
            return switch (value) {
                case "+" -> ADD;
                case "-" -> Operator.SUBTRACT;
                case "*" -> MULTIPLY;
                case "/" -> DIVIDE;
                default -> throw new IllegalArgumentException("Invalid operator: " + value);
            };
        }
    }

    enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
