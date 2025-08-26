package com.adolfoeloy.calculator;


import java.util.Stack;

/**
 * Basic calculator with 4 math operations (+,-,*,/) without parenthesis
 */
public class CalculatorBasicII {

    public int calculate(String s) {
        int num = 0;
        char operator = '+';
        var sum = new Stack<Integer>();
        s = s.replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            var token = s.charAt(i);
            var lastToken = i == s.length() - 1;

            if (Character.isDigit(token)) {
                num = num * 10 + (token - '0');
            }

            if (isOperator(token) || lastToken) {
                switch (operator) {
                    case '+':
                        sum.push(num);
                        break;
                    case '-':
                        sum.push(-num);
                        break;
                    case '*':
                        sum.push(sum.pop() * num);
                        break;
                    case '/':
                        sum.push(sum.pop() / num);
                        break;
                    default:
                        // noop
                }
                operator = token;
                num = 0;
            }
        }

        while (sum.size() > 1) {
            sum.push(sum.pop() + sum.pop());
        }

        return sum.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
