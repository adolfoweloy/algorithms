package com.adolfoeloy.datastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueWithStackTest {

    private QueueWithStack queue = new QueueWithStack();

    @Test
    @DisplayName("simple usage of the queue")
    void testCase1() {
        queue.push(1);
        queue.push(2);
        assertThat(queue.peek()).isEqualTo(1);
        assertThat(queue.pop()).isEqualTo(1);
        assertThat(queue.empty()).isFalse();
    }
}