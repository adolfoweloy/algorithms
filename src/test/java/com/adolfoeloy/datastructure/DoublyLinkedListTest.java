package com.adolfoeloy.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublyLinkedListTest {

    @Test
    void shouldWork() {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList.NodeValue node1 = list.addFront(10);
        DoublyLinkedList.NodeValue node2 = list.addFront(20);
        DoublyLinkedList.NodeValue node3 = list.addFront(30);

        assertEquals(3, list.size());
        assertEquals(node3.next, node2);
        assertEquals(node2.next, node1);
        assertEquals(node1.prev, node2);

        list.remove(node2);

        assertEquals(2, list.size());
        assertEquals(node1, node3.next);
        assertEquals(node3, node1.prev);
    }

}