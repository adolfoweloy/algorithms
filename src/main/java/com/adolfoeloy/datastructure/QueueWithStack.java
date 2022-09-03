package com.adolfoeloy.datastructure;

import java.util.Stack;

/**
 * This is an implementation of a queue using stacks.
 */
public class QueueWithStack {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> tmp = new Stack<>();

    public void push(int x) {
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        stack.push(x);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
