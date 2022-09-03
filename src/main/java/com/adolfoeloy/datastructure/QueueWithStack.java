package com.adolfoeloy.datastructure;

import java.util.Stack;

/**
 * This is an implementation of a queue using stacks.
 */
public class QueueWithStack {
    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();
    private Integer front;

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek() {
        if (empty()) throw new IllegalStateException("The queue is empty");
        if (!s2.empty()) {
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
