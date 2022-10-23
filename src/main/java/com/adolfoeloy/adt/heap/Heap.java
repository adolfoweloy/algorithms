package com.adolfoeloy.adt.heap;

public interface Heap<T extends Comparable<T>> {
    void add(T entry);

    T pop();

    T peek();

    int size();

    T[] getHeap();
}
