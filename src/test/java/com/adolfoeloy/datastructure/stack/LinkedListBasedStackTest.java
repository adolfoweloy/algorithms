package com.adolfoeloy.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListBasedStackTest {

    @Test
    void should_have_size_zero_when_the_stack_is_recently_created() {
        Stack<Integer> stack = new LinkedListBasedStack<>();
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void should_have_size_one_when_an_item_is_pushed_onto_an_empty_stack() {
        Stack<Integer> stack = new LinkedListBasedStack<>();
        stack.push(10);
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void should_have_size_zero_after_pushing_an_item_and_popping_it_out() {
        Stack<Integer> stack = new LinkedListBasedStack<>();
        stack.push(10);
        var item = stack.pop();
        assertThat(item).isEqualTo(10);
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
    }

}