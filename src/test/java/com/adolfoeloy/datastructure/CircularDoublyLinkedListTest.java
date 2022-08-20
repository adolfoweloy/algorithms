package com.adolfoeloy.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircularDoublyLinkedListTest {

    CircularDoublyLinkedList cdl = new CircularDoublyLinkedList();
    CircularDoublyLinkedList.QueueNode<Integer> q1;
    CircularDoublyLinkedList.QueueNode<Integer> q2;
    CircularDoublyLinkedList.QueueNode<Integer> q3;

    @BeforeEach
    void setUp() {
        q1 = new CircularDoublyLinkedList.QueueNode<>(1);
        q2 = new CircularDoublyLinkedList.QueueNode<>(2);
        q3 = new CircularDoublyLinkedList.QueueNode<>(3);

        cdl.addTail(q1, q2);
        cdl.addTail(q1, q3);
    }

    @Test
    void shouldHaveThreeElements() {
        assertEquals(3, cdl.size(q1));
    }

    @Test
    void shouldBeAbleToIterate() {
        List<Integer> elements = new ArrayList<>();
        cdl.forEach(q -> elements.add(q.data), q1);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, elements);
    }
}