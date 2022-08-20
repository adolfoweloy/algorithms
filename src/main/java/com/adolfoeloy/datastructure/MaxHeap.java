package com.adolfoeloy.datastructure;

/**
 * MaxHeap implementation backed by an array of Integers that is resizable.
 */
public class MaxHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    MaxHeap(int capacity) {
        heap = (T[]) new Comparable[capacity];
        size = 0;
    }

    public void add(T entry) {
        if (size == heap.length) {
            resize(size * 2);
        }

        heap[size] = entry;

        for (int k = size; less(parent(k), k); k = parent(k)) {
            swap(parent(k), k);
        }

        size++;
    }

    public T remove() {
        if (size == heap.length) {
            throw new  IllegalStateException("Heap is empty");
        }

        swap(first(), last());

        T entry = heap[last()];
        heap[last()] = null;
        size--;

        sink(first());

        if (size <= heap.length / 4) {
            resize(heap.length / 2);
        }

        return entry;
    }

    private int first() {
        return 0;
    }

    private int last() {
        return size - 1;
    }

    private void sink(int k) {
        while (left(k) < size) {
            int j = left(k);
            if (j < size && less(left(k), right(k))) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    boolean less(int i, int j) {
        if (heap[j] == null) return false;
        return heap[i].compareTo(heap[j]) < 0;
    }

    private int left(int k) {
        return (k * 2) + 1;
    }

    private int right(int k) {
        return (k * 2) + 2;
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        T[] tmp = (T[]) new Comparable[newSize];
        for (int i=0; i<heap.length && i<tmp.length; i++)
            tmp[i] = heap[i];
        heap = tmp;
    }

    // Visible for testing
    T[] getHeap() {
        return heap;
    }
}
