package com.adolfoeloy.adt.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxHeapTest {

    @Test
    void add__should_add_numbers_in_max_order() {
        MaxHeap<Integer> heap = new MaxHeap<>(4);
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(6);
        heap.add(22);

        Assertions.assertArrayEquals(new Integer[] {22, 20, 10, 5, 6, null, null, null}, heap.getHeap());
    }

    @Test
    void remove__should_return_max_element() {
        MaxHeap<Integer> heap = new MaxHeap<>(4);
        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(6);
        heap.add(22);

        Assertions.assertEquals(22, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {20, 6, 10, 5, null, null, null, null}, heap.getHeap());

        Assertions.assertEquals(20, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {10, 6, 5, null, null, null, null, null}, heap.getHeap());

        Assertions.assertEquals(10, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {6, 5, null, null}, heap.getHeap());

        Assertions.assertEquals(6, heap.pop());
        Assertions.assertArrayEquals(new Integer[] {5, null}, heap.getHeap());
    }
}