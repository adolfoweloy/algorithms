package com.adolfoeloy.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeapPriorityQueueTest {

    @Test
    void size__should_be_zero_when_max_heap_is_created() {
        var heap = new PriorityQueue<Integer>(10);
        assertThat(heap).isEmpty();
    }

    @Test
    void asArray__should_return_an_empty_array_of_size_max_size_when_heap_is_created() {
        assertThat(new PriorityQueue<Integer>(3).toArray()).isEmpty();
    }

    @Test
    void add__should_add_values_in_the_right_order_for_max_heap() {
        var heap = new PriorityQueue<Integer>(5, Collections.reverseOrder());
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var result = heap.toArray();

        assertThat(result).containsExactly(10, 9, 4, 5, 7);
    }

    @Test
    void add__should_add_values_in_the_right_order_for_min_heap() {
        var heap = new PriorityQueue<Integer>(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var result = heap.toArray();

        assertThat(result).containsExactly(4, 7, 5, 10, 9);
    }

    @Test
    void add__should_resize_heap_if_adding_more_than_initial_capacity() {
        var heap = new PriorityQueue<Integer>(2);

        IntStream.of(5, 9, 10).forEach(heap::add);

        assertThat(heap).containsExactly(5, 9, 10);
    }

    @Test
    void poll__should_pick_the_larges_element_in_the_max_heap() {
        var heap = new PriorityQueue<Integer>(5, Collections.reverseOrder());
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var max = heap.poll();

        assertThat(max).isEqualTo(10);
    }

    @Test
    void poll__should_pick_the_smallest_element_in_the_min_heap() {
        var heap = new PriorityQueue<Integer>(5);
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var max = heap.poll();

        assertThat(max).isEqualTo(4);
    }

    @Test
    void poll__should_pick_the_larges_element_from_the_heap_after_subsequent_calls() {
        var heap = new PriorityQueue<Integer>(5, Collections.reverseOrder());
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        assertThat(heap.poll()).isEqualTo(10);
        assertThat(heap.poll()).isEqualTo(9);

        assertThat(heap.toArray()).containsExactly(7, 5, 4);
    }

    @Test
    void poll__should_pick_all_the_larges_elements_from_the_heap() {
        var heap = new PriorityQueue<Integer>(5, Collections.reverseOrder());
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        assertThat(heap.poll()).isEqualTo(10);
        assertThat(heap.poll()).isEqualTo(9);
        assertThat(heap.poll()).isEqualTo(7);
        assertThat(heap.poll()).isEqualTo(5);
        assertThat(heap.poll()).isEqualTo(4);

        assertThat(heap.toArray()).isEmpty();
    }

    @Test
    void poll__should_throw_exception_if_trying_to_delete_from_empty_heap() {
        var heap = new PriorityQueue<Integer>(5);

        var result = heap.poll();

        assertThat(result).isNull(); // oh no Java, seriously?
    }

    @Test
    void peek__should_return_the_value_of_max_value_without_removing_it_from_heap() {
        var heap = new PriorityQueue<Integer>(5, Collections.reverseOrder());
        IntStream.of(5, 9, 4, 10, 7).forEach(heap::add);

        var value = heap.peek();

        assertThat(value).isEqualTo(10);
        assertThat(heap.size()).isEqualTo(5);
        assertThat(heap.toArray()).containsExactly(10, 9, 4, 5, 7);
    }

    @Test
    void peek__should_throw_an_exception_if_trying_to_peek_from_an_empty_list() {
        var heap = new PriorityQueue<Integer>(5);

        var value = heap.peek();

        assertThat(value).isNull(); // I knew it :(
    }

    @Test
    void construct__should_fully_heapify_a_given_array_but_it_can_only_create_min_heap() {
        var heap = new PriorityQueue<>(List.of(1, 2, 3, 4, 5));

        assertThat(heap.toArray()).containsExactly(1, 2, 3, 4, 5);
    }
}
