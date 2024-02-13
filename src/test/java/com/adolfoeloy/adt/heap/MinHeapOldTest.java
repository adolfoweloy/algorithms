package com.adolfoeloy.adt.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinHeapOldTest {

    @Test
    void add__should_add_numbers_in_min_order_without_resizing() {
        Heap<Integer> heap = new MinHeapOld<>(4);
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(6);

        Assertions.assertArrayEquals(new Integer[] {null, 5, 6, 20, 10}, heap.getHeap());
    }

    @Test
    void add__should_add_numbers_in_min_order_resizing() {
        Heap<Integer> heap = new MinHeapOld<>(4);
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(6);
        heap.add(22);

        Assertions.assertArrayEquals(new Integer[] {null, 5, 6, 20, 10, 22, null, null, null, null}, heap.getHeap());
    }

    @Test
    void remove__should_return_min_element_without_resizing() {
        Heap<Integer> heap = new MinHeapOld<>(4);
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(6);

        Assertions.assertEquals(5, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {null, 6, 10, 20, null}, heap.getHeap());

        Assertions.assertEquals(6, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {null, 10, 20, null, null}, heap.getHeap());

        Assertions.assertEquals(10, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {null, 20}, heap.getHeap());

        Assertions.assertEquals(20, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {null, null}, heap.getHeap());
    }

    @Test
    void remove__should_return_min_element_resizing() {
        Heap<Integer> heap = new MinHeapOld<>(4);
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(6);
        heap.add(22);

        Assertions.assertEquals(5, heap.pop());
        Assertions.assertArrayEquals(new Integer[]  {null, 6, 10, 20, 22, null, null, null, null, null}, heap.getHeap());

        Assertions.assertEquals(6, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {null, 10, 22, 20, null, null, null, null, null, null}, heap.getHeap());

        Assertions.assertEquals(10, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {null, 20, 22, null, null}, heap.getHeap());

        Assertions.assertEquals(20, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {null, 22}, heap.getHeap());
    }
}