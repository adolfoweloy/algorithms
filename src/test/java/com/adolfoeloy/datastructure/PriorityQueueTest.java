package com.adolfoeloy.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Experiments with Java PriorityQueue
 */
public class PriorityQueueTest {

    private static Comparator<Integer> DESCENDING_ORDER = (a, b) -> b - a;

    @Test
    public void should_get_the_larger_number_after_adding_three_entries() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(DESCENDING_ORDER);
        pq.add(1000);
        pq.add(150);
        pq.add(1050);

        Assertions.assertEquals(1050, pq.poll());
        Assertions.assertEquals(1000, pq.poll());
        Assertions.assertEquals(150, pq.poll());
    }

    @Test
    public void should_respect_the_priority_in_case_the_reference_changes() {
        PriorityQueue<MyPojo> pq = new PriorityQueue<>();

        MyPojo naruto = new MyPojo("Naruto", 10);
        MyPojo kakashi = new MyPojo("Kakashi", 5);
        MyPojo orochimaru = new MyPojo("Orochimaru", 1);

        pq.add(naruto);
        pq.add(kakashi);
        pq.add(orochimaru);

        Assertions.assertEquals("Naruto", pq.peek().value);

        orochimaru.priority = 50; // change the value used to sort the PQ doesn't rearrange the PQ
        Assertions.assertEquals("Naruto", pq.peek().value);
    }

    private static class MyPojo implements Comparable<MyPojo> {
        String value;
        Integer priority;
        MyPojo(String value, Integer priority) {
            this.value = value;
            this.priority = priority;
        }
        @Override
        public int compareTo(MyPojo other) {
            return other.priority - this.priority;
        }
    }
}
