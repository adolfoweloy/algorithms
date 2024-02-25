package com.adolfoeloy.datastructure.stack;

public class ArrayBasedStack<T> implements Stack<T> {

    private T[] items;
    private int n;

    @SuppressWarnings("unchecked")
    ArrayBasedStack(int capacity) {
        items = (T[]) new Object[capacity];
    }
    @Override
    public void push(T item) {
        if (n == items.length) {
            resize(n * 2);
        }
        items[n++] = item;
    }

    @Override
    public T pop() {
        T item = items[--n];
        items[n] = null; // avoid loitering
        if (n > 0 && n == items.length / 4) {
            resize(n / 2);
        }
        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] copy = (T[]) new Object[newCapacity];
        if (n >= 0) System.arraycopy(items, 0, copy, 0, n);
        items = copy;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

}
