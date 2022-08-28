package com.adolfoeloy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (isClose(c)) {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (!matches(open, c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isClose(char c) {
        return (c == ')') || (c == ']') || (c == '}');
    }

    private boolean matches(char open, char close) {
        switch (open) {
            case '(':
                return close == ')';
            case '[':
                return close == ']';
            case '{':
                return close == '}';
            default:
                return false;
        }
    }
}
