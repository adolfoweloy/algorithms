package com.adolfoeloy.datastructure.stack;

public class LinkedListBasedStack<T> implements Stack<T> {

    private Node first = null;
    private int n = 0;

    @Override
    public void push(T item) {
        Node oldFirst = first;
        Node newNode = new Node(item);
        newNode.next = oldFirst;
        first = newNode;
        n++;
    }

    @Override
    public T pop() {
        Node tmp = first;
        first = first.next;
        n--;
        return tmp.item;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    private class Node {
        private final T item;
        private Node next;

        Node(T item) { this.item = item; }

        @Override
        public String toString() {
            return "item: " + item;
        }
    }
}
