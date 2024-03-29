package com.adolfoeloy.datastructure.heap;

import java.util.Arrays;

public class MaxHeap implements IntHeap {
    private int size;
    private final int[] heap;

    MaxHeap(int maxSize) {
        heap = new int[maxSize + 1];
    }

    MaxHeap(int[] input) {
        heap = new int[input.length + 1];
        Arrays.stream(input).forEach(this::add);
    }

    @Override
    public void add(int value) {
        if (size + 1 == heap.length) {
            throw new IllegalStateException("Can't add more entries to a heap of size " + (heap.length - 1));
        }

        size++;

        // adding the value to the end of the heap
        // running time to add a new entry is O(1)
        var latestPos = size;
        heap[latestPos] = value;

        // now bubble the value up to keep the heap consistent
        swim(latestPos);
    }

    @Override
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        var max = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        size--;

        var index = 1;
        sink(index);

        return max;
    }

    // running time to swim up values is O(log N)
    private void swim(int index) {
        while (index > 1) {
            var parent = index / 2;
            if (heap[index] > heap[parent]) {
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
                var maxIndex = indexOfMaxBetween(left, right);
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                if (heap[index] < heap[left]) {
                    swap(index, left);
                }
                index = left;
            }
        }
    }

    private int indexOfMaxBetween(int i, int j) {
        if (heap[i] >= heap[j]) {
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
    public int peek() {
        if (size == 0) throw new IllegalStateException("The heap is empty");
        return heap[1];
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
