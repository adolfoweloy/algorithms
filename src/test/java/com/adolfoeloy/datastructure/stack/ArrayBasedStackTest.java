package com.adolfoeloy.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayBasedStackTest {

    @Test
    void should_have_size_zero_when_the_stack_is_recently_created() {
        Stack<Integer> stack = new ArrayBasedStack<>(1);
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void should_have_size_one_when_an_item_is_pushed_onto_an_empty_stack() {
        Stack<Integer> stack = new ArrayBasedStack<>(1);
        stack.push(10);
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void should_have_size_zero_after_pushing_an_item_and_popping_it_out() {
        Stack<Integer> stack = new ArrayBasedStack<>(1);
        stack.push(10);
        var item = stack.pop();
        assertThat(item).isEqualTo(10);
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void should_have_size_two_after_pushing_two_items_and_one_after_popping_the_latest_added() {
        Stack<Integer> stack = new ArrayBasedStack<>(2);
        stack.push(10);
        stack.push(20);
        var item = stack.pop();
        assertThat(item).isEqualTo(20);
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void should_adjust_capacity_if_adding_more_than_specified_for_initial_capacity() {
        Stack<Integer> stack = new ArrayBasedStack<>(2);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        var item = stack.pop();
        assertThat(item).isEqualTo(30);
        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.isEmpty()).isFalse();
    }
}