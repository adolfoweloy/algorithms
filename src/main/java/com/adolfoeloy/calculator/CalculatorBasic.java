package com.adolfoeloy.calculator;

import java.util.Stack;

/**
 * Calculator basic is the simplest calculator problem from leetcode.
 * It consists of expressions with numbers, sum operators and parenthesis.
 */
public class CalculatorBasic {

    public int calculate(String s) {
        if (s == null) return 0;

        var result = new Stack<Integer>();

        int sum=0;
        int num=0;
        int sign=1; // 1 for positive and -1 for negative

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                sum += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                sum += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                result.push(sum);
                result.push(sign);

                sign = 1;
                sum = 0;
            } else if (c == ')') {
                sum += sign * num;
                sum *= result.pop();
                sum += result.pop();

                num = 0;
            }
        }

        sum += sign * num;
        return sum;
    }

}
