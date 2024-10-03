package com.adolfoeloy.datastructure.heap;

import java.util.Arrays;

public class MaxHeap implements IntHeap {
    private int size;
    private final int[] heap;

    public MaxHeap(int capacity) {
        this.heap = new int[capacity + 1]; // the array will start at 1
    }

    public MaxHeap(int[] items) {
        heap = new int[items.length + 1];
        size = items.length;
        System.arraycopy(items, 0, heap, 1, items.length);
        heapify();
    }

    /**
     * build heap using bottom-up method
     * size/2 because there's no need to perform sink operation on leaf nodes.
     */
    private void heapify() {
        for (int k = size/2; k >= 1; k--) {
            sink(k, heap);
        }
    }

    @Override
    public void add(int value) {
        if (size+1 == heap.length) {
            throw new IllegalStateException("Can't add more entries to a heap of size " + (heap.length - 1));
        }
        heap[++size] = value; // add the entry to the end of the heap
        swim(size);
    }

    @Override
    public int poll() {
        if (size == 0) throw new IllegalStateException("Cannot poll from an empty heap");
        int value = heap[1];
        swap(1, size, heap);
        heap[size--] = 0;
        sink(1, heap);
        return value;
    }

    @Override
    public int peek() {
        if (size == 0) throw new IllegalStateException("Cannot peek from an empty heap");
        return heap[1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] asArray() {
        int[] result = new int[size];
        System.arraycopy(heap, 1, result, 0, size);
        return result;
    }

    public int[] heapSort() {
        int[] sorted = new int[heap.length];
        // the cool thing about the heap sort is that you can
        // 1. heapify the array
        // 2. do the swap and sink in place with no need for extra memory.
        // however, for this implementation I copy the heap into another array to not mutate the heap.
        System.arraycopy(heap, 0, sorted, 0, heap.length);

        int tmp = size;
        while (size > 0) {
            swap(1, size--, sorted);
            sink(1, sorted);
        }

        size = tmp;
        return Arrays.copyOfRange(sorted, 1, size+1);
    }

    private void sink(int k, int[] array) {
        while (2*k <= size) {
            int j = 2*k;
            // testing with an array with only negative values, allows me to find the reason why the check j < size
            // is important here. If not present, it turns out that a zeroed entry which is not within the heap's boundaries
            // will be compared with the latest negative value on the left child and k will be swapped with that invalid 0 entry.
            // that is what actually means going off the end of the heap ;)
            if (j < size && array[j+1] > array[j]) j++;
            if (array[k] > array[j]) break;
            swap(k, j, array);
            k = j;
        }
    }

    private void swim(int index) {
        if (size == 1) return;
        int k = index;
        while (k > 1 && heap[k] > heap[k/2]) {
            swap(k, k/2, heap);
            k = k/2;
        }
    }

    private void swap(int i, int j, int[] array) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
