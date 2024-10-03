package com.adolfoeloy.datastructure.heap;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaxHeapTest {

    @Test
    void size__should_be_zero_when_max_heap_is_created() {
        var heap = new MaxHeap(10);
        assertThat(heap.size()).isEqualTo(0);
    }

    @Test
    void asArray__should_return_an_empty_array_of_size_max_size_when_heap_is_created() {
        var heap = new MaxHeap(3);
        assertThat(heap.asArray()).isEmpty();
    }

    @Test
    void add__should_add_values_in_the_right_order() {
        var heap = new MaxHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var result = heap.asArray();

        assertThat(result).containsExactly(10, 9, 4, 5, 7);
    }

    @Test
    void add__should_throw_exception_if_adding_more_than_max_size() {
        var heap = new MaxHeap(2);

        assertThrows(IllegalStateException.class, () -> IntStream.of(5, 9, 10).forEach(heap::add));
    }

    @Test
    void poll__should_pick_the_larges_element_in_the_heap() {
        var heap = new MaxHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var max = heap.poll();

        assertThat(max).isEqualTo(10);
    }

    @Test
    void poll__should_pick_the_larges_element_from_the_heap_after_subsequent_calls() {
        var heap = new MaxHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        assertThat(heap.poll()).isEqualTo(10);
        assertThat(heap.poll()).isEqualTo(9);

        assertThat(heap.asArray()).containsExactly(7, 5, 4);
    }

    @Test
    void poll__should_pick_all_the_larges_elements_from_the_heap() {
        var heap = new MaxHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        assertThat(heap.asArray()).containsExactly(10, 9, 4, 5, 7);


        assertThat(heap.poll()).isEqualTo(10);
        assertThat(heap.poll()).isEqualTo(9);
        assertThat(heap.poll()).isEqualTo(7);
        assertThat(heap.poll()).isEqualTo(5);
        assertThat(heap.poll()).isEqualTo(4);

        assertThat(heap.asArray()).isEmpty();
    }

    @Test
    void poll__should_not_compare_elements_outside_of_the_heap_boundaries() {
        var heap = new MaxHeap(3);
        IntStream.of(-5, -9, -4).forEach(heap::add);

        // this will force comparison between 0 on the left side with 0 on the right side
        assertThat(heap.asArray()).containsExactly(-4, -9, -5);

        assertThat(heap.poll()).isEqualTo(-4);
        assertThat(heap.poll()).isEqualTo(-5);
        assertThat(heap.poll()).isEqualTo(-9);

        assertThat(heap.asArray()).isEmpty();
    }

    @Test
    void poll__should_throw_exception_if_trying_to_delete_from_empty_heap() {
        var heap = new MaxHeap(5);

        assertThrows(IllegalStateException.class, heap::poll);
    }

    @Test
    void peek__should_return_the_value_of_max_value_without_removing_it_from_heap() {
        var heap = new MaxHeap(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var value = heap.peek();

        assertThat(value).isEqualTo(10);
        assertThat(heap.size()).isEqualTo(5);
        assertThat(heap.asArray()).containsExactly(10, 9, 4, 5, 7);
    }

    @Test
    void peek__should_throw_an_exception_if_trying_to_peek_from_an_empty_list() {
        var heap = new MaxHeap(5);

        assertThrows(IllegalStateException.class, heap::peek);
    }

    @Test
    void construct__should_fully_heapify_a_given_array() {
        var heap = new MaxHeap(new int[] {1, 2, 3, 4, 5});

        assertThat(heap.asArray()).containsExactly(5, 4, 3, 1, 2);
    }
}
