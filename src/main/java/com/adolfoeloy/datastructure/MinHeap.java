package com.adolfoeloy.datastructure;

import java.util.Arrays;

public class MinHeap implements IntHeap {
    private int size;
    private final int[] heap;

    public MinHeap(int maxSize) {
        heap = new int[maxSize + 1];
    }

    public MinHeap(int[] input) {
        heap = new int[input.length + 1];
        Arrays.stream(input).forEach(this::add);
    }

    @Override
    public void add(int value) {
        if (size + 1 == heap.length) {
            throw new IllegalStateException("Cannot add more than heap max size");
        }
        size++;
        int index = size;
        heap[index] = value;
        swim(index);
    }

    @Override
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        var min = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        size--;

        var index = 1;
        sink(index);

        return min;
    }

    @Override
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap[1];
    }

    private void swim(int index) {
        while (index > 0) {
            var parent = index / 2;
            if (heap[index] < heap[parent]) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void sink(int index) {
        while (index <= size / 2) {
            var left = index * 2;
            var right = index * 2 + 1;
            if (right < size) {
                var minIndex = minIndexBetween(left, right);
                swap(index, minIndex);
                index = minIndex;
            } else {
                if (heap[index] > heap[left]) {
                    swap(index, left);
                }
                index = left;
            }
        }
    }

    int minIndexBetween(int i, int j) {
        if (heap[i] <= heap[j]) {
            return i;
        }
        return j;
    }

    private void swap(int index, int parent) {
        var tmp = heap[index];
        heap[index] = heap[parent];
        heap[parent] = tmp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] asArray() {
        return Arrays.copyOfRange(heap, 1, size + 1);
    }
}
