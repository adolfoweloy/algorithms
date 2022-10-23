package com.adolfoeloy.adt.heap;

public class HeapUtil<T extends Comparable<T>> {

    void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    boolean lessOrEqual(T[] a, int i, int j) {
        return a[i].compareTo(a[j]) <= 0;
    }

    int left(int k) {
        return 2 * k;
    }

    int right(int k) {
        return 2 * k + 1;
    }

    int parent(int k) {
        return k / 2;
    }

    int first() {
        return  1;
    }
}
