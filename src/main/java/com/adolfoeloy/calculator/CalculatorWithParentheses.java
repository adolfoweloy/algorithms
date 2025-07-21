package com.adolfoeloy.calculator;

import java.util.Stack;


public class CalculatorWithParentheses {

    record Token(String value) {
        static Token fromChar(char c) {
            return new Token(String.valueOf(c));
        }

        static Token fromInt(int i) {
            return new Token(String.valueOf(i));
        }

        boolean isOperator() {
            return "+-*/".contains(value);
        }

        boolean isNumber() {
            return value.matches("-?\\d+"); // come back later
        }

        int toNumber() {
            return Integer.parseInt(value);
        }

        char toOperator() {
            return value.charAt(0);
        }
    }

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        var expression = s.concat("@"); // dumb character
        var currentNumber = 0;
        var lastOperator = '+';
        var stack = new Stack<Token>();

        for (char token : expression.toCharArray()) {
            if (token == ' ') {
                continue; // skip spaces
            }

            if (Character.isDigit(token)) {
                currentNumber = currentNumber * 10 + (token - '0');
            } else if (token == '(') {
                stack.push(Token.fromChar(lastOperator));
                lastOperator = '+';
            } else {
                switch (lastOperator) {
                    case '+' -> stack.push(Token.fromInt(currentNumber));
                    case '-' -> stack.push(Token.fromInt(-currentNumber));
                    case '*' -> stack.push(Token.fromInt(stack.pop().toNumber() * currentNumber));
                    case '/' -> stack.push(Token.fromInt(stack.pop().toNumber() / currentNumber));
                }

                currentNumber = 0;
                lastOperator = token;

                if (token == ')') {
                    while (!stack.isEmpty() && stack.peek().isNumber()) {
                        currentNumber += stack.pop().toNumber();
                    }
                    lastOperator = stack.pop().toOperator();
                }
            }
        }

        var result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop().toNumber();
        }

        return result;
    }
}
