package com.adolfoeloy.datastructure;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MinHeapTest {

    @Test
    void size__should_be_zero_when_max_heap_is_created() {
        var heap = new MinHeap(10);
        assertThat(heap.size()).isEqualTo(0);
    }

    @Test
    void asArray__should_return_an_empty_array_of_size_min_size_when_heap_is_created() {
        var heap = new MinHeap(3);
        assertThat(heap.asArray()).isEmpty();
    }

    @Test
    void add__should_add_values_in_the_right_order() {
        var heap = new MinHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var result = heap.asArray();

        assertThat(result).containsExactly(4, 7, 5, 10, 9);
    }

    @Test
    void add__should_throw_exception_if_adding_more_than_max_size() {
        var heap = new MinHeap(2);

        assertThrows(IllegalStateException.class, () -> IntStream.of(5, 9, 10).forEach(heap::add));
    }

    @Test
    void poll__should_pick_the_larges_element_in_the_heap() {
        var heap = new MinHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var min = heap.poll();

        assertThat(min).isEqualTo(4);
        assertThat(heap.asArray()).containsExactly(5, 7, 9, 10);
    }

    @Test
    void poll__should_pick_the_smallest_element_from_the_heap_after_subsequent_calls() {
        var heap = new MinHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        assertThat(heap.poll()).isEqualTo(4);
        assertThat(heap.poll()).isEqualTo(5);

        assertThat(heap.asArray()).containsExactly(7, 10, 9);
    }

    @Test
    void poll__should_pick_all_the_smallest_elements_from_the_heap() {
        var heap = new MinHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        assertThat(heap.poll()).isEqualTo(4);
        assertThat(heap.poll()).isEqualTo(5);
        assertThat(heap.poll()).isEqualTo(7);
        assertThat(heap.poll()).isEqualTo(9);
        assertThat(heap.poll()).isEqualTo(10);

        assertThat(heap.asArray()).isEmpty();
    }

    @Test
    void poll__should_throw_exception_if_trying_to_delete_from_empty_heap() {
        var heap = new MinHeap(5);

        assertThrows(IllegalStateException.class, heap::poll);
    }

    @Test
    void peek__should_return_the_value_of_min_value_without_removing_it_from_heap() {
        var heap = new MinHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var value = heap.peek();

        assertThat(value).isEqualTo(4);
        assertThat(heap.size()).isEqualTo(5);
        assertThat(heap.asArray()).containsExactly(4, 7, 5, 10, 9);
    }

    @Test
    void peek__should_throw_an_exception_if_trying_to_peek_from_an_empty_list() {
        var heap = new MinHeap(5);

        assertThrows(IllegalStateException.class, heap::peek);
    }

    @Test
    void construct__should_fully_heapify_a_given_array() {
        var heap = new MinHeap(new int[] {1, 2, 3, 4, 5});

        assertThat(heap.asArray()).containsExactly(1, 2, 3, 4, 5);
    }
}