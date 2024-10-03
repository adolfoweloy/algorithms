package com.adolfoeloy.datastructure.heap;

public class MaxHeap implements IntHeap {
    private int size;
    private final int[] heap;

    public MaxHeap(int capacity) {
        this.heap = new int[capacity + 1]; // the array will start at 1
    }

    public MaxHeap(int[] items) {
        heap = new int[items.length + 1];
        for (int item: items) {
            add(item);
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
        swap(1, size);
        heap[size--] = 0;
        sink(1);
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

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            // testing with an array with only negative values, allows me to find the reason why the check j < size
            // is important here. If not present, it turns out that a zeroed entry which is not within the heap's boundaries
            // will be compared with the latest negative value on the left child and k will be swapped with that invalid 0 entry.
            // that is what actually means going off the end of the heap ;)
            if (j < size && heap[j+1] > heap[j]) j++;
            if (heap[k] > heap[j]) break;
            swap(k, j);
            k = j;
        }
    }

    private void swim(int index) {
        if (size == 1) return;
        int k = index;
        while (k > 1 && heap[k] > heap[k/2]) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[j];
        heap[j] = heap[i];
        heap[i] = tmp;
    }

}
