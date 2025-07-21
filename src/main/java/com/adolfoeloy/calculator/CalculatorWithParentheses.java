package com.adolfoeloy.calculator;

import java.util.Stack;


public class CalculatorWithParentheses {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        var expression = s.concat("@"); // dumb character
        var currentNumber = 0;
        var lastOperator = Operator.ADD; // default operator
        var stack = new Stack<Token>();

        for (char c : expression.toCharArray()) {
            if (c == ' ') {
                continue; // skip spaces
            }
            var token = Token.fromChar(c);
            if (token.isNumber()) {
                currentNumber = currentNumber * 10 + token.toNumber();
            } else if (token.isOpenBracket()) {
                stack.push(Token.valueOf(lastOperator));
                lastOperator = Operator.ADD; // reset to default operator
            } else {
                switch (lastOperator) {
                    case ADD -> stack.push(Token.fromInteger(currentNumber));
                    case SUBTRACT -> stack.push(Token.fromInteger(-currentNumber));
                    case MULTIPLY -> stack.push(Token.fromInteger(stack.pop().toNumber() * currentNumber));
                    case DIVIDE -> stack.push(Token.fromInteger(stack.pop().toNumber() / currentNumber));
                }

                lastOperator = token.isOperator() ? token.toOperator() : Operator.ADD; // default to ADD if not an operator
                currentNumber = 0; // reset for next number

                if (token.isCloseBracket()) {
                    while (!stack.isEmpty() && !stack.peek().isOperator()) {
                        currentNumber += stack.pop().toNumber();
                    }
                    if (!stack.isEmpty() && stack.peek().isOperator()) {
                        lastOperator = stack.pop().toOperator();
                    }
                }
            }
        }

        var result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop().toNumber();
        }
        return result;
    }

    record Token(String value) {
        static Token fromChar(char c) {
            return new Token(String.valueOf(c));
        }

        static Token fromInteger(int number) {
            return new Token(String.valueOf(number));
        }

        static Token valueOf(Operator value) {
            return new Token(value.symbol);
        }

        boolean isOpenBracket() {
            return value.equals("(");
        }

        boolean isCloseBracket() {
            return value.equals(")");
        }

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
                case "+" -> Operator.ADD;
                case "-" -> Operator.SUBTRACT;
                case "*" -> Operator.MULTIPLY;
                case "/" -> Operator.DIVIDE;
                default -> throw new IllegalArgumentException("Invalid operator: " + value);
            };
        }
    }

    enum Operator {
        ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

        private String symbol;

        Operator(String s) {
            this.symbol = s;
        }

        String getSymbol() {
            return symbol;
        }
    }
}
