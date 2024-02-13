package com.adolfoeloy.adt.heap;

public class MinHeapOld<T extends Comparable<T>> implements Heap<T> {
    private T[] heap;
    private int capacity;
    private int size = 0;
    private final HeapUtil<T> heapUtil = new HeapUtil<>();

    @SuppressWarnings("unchecked")
    public MinHeapOld(int capacity) {
        heap = (T[]) new Comparable[capacity + 1];
        this.capacity = capacity;
    }

    @Override
    public void add(T entry) {
        if (size == capacity) {
            resize(2 * heap.length);
        }

        heap[++size] = entry;

        int k = last();
        while (k > 1) {
            if (heapUtil.lessOrEqual(heap, k, heapUtil.parent(k))) {
                heapUtil.swap(heap, k, heapUtil.parent(k));
            }
            k = heapUtil.parent(k);
        }
    }

    @Override
    public T pop() {
        if (size == 0) throw new IllegalStateException("Heap is empty");

        T min = heap[heapUtil.first()];
        heapUtil.swap(heap, heapUtil.first(), last());
        heap[last()] = null;
        size--;

        int k = 1;
        while (2 * k <= size) {
            int j = heapUtil.left(k);
            if (j < size && heapUtil.lessOrEqual(heap, heapUtil.right(k), heapUtil.left(k))) j++;
            if (heapUtil.lessOrEqual(heap, k, j)) break;
            heapUtil.swap(heap, j, k);
            k = j;
        }

        if (size > 0 && (size == (heap.length - 1) / 4)) {
            resize(heap.length / 2);
        }

        return min;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        this.capacity = newCapacity;
        T[] tmp = (T[]) new Comparable[newCapacity];
        for (int i = 0; i < heap.length && i < tmp.length; i++) {
            tmp[i] = heap[i];
        }
        heap = tmp;
    }

    @Override
    public T peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[heapUtil.first()];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] getHeap() {
        return heap;
    }

    private int last() {
        return size;
    }
}
