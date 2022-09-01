package com.adolfoeloy.datastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class MyLinkedListTest {

    private MyLinkedList list = new MyLinkedList();;

    @Test
    @DisplayName("should be able to add an element to an empty list")
    void testCase1() {
        list.addAtHead(1);

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.toArrayList()).isEqualTo(asList(1));
    }

    @Test
    @DisplayName("should be able to add an element to the head of a non empty list")
    void testCase2() {
        list.addAtHead(1);
        list.addAtHead(2);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.toArrayList()).isEqualTo(asList(2, 1));
    }

    @Test
    @DisplayName("should be able to add an element to the tail of a non empty list")
    void testCase3() {
        list.addAtHead(1);
        list.addAtTail(2);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.toArrayList()).isEqualTo(asList(1, 2));
    }

    @Test
    @DisplayName("should be able to get an element from the linked list")
    void testCase4() {
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(3);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(10)).isEqualTo(-1);
    }

    @Test
    @DisplayName("should return -1 when the index is not valid")
    void testCase41() {

    }
    @Test
    @DisplayName("should be able to add at a given index")
    void testCase5() {
        list.addAtHead(3);
        list.addAtTail(4);
        list.addAtTail(1);

        assertThat(list.size()).isEqualTo(3);

        list.addAtIndex(1, 10);
        assertThat(list.size()).isEqualTo(4);

        assertThat(list.get(0)).isEqualTo(3);
        assertThat(list.get(1)).isEqualTo(10);
        assertThat(list.get(2)).isEqualTo(4);
        assertThat(list.get(3)).isEqualTo(1);
    }

    @Test
    @DisplayName("should delete at index")
    void testCase6() {
        list.addAtHead(3);
        list.addAtTail(4);
        list.addAtTail(1);

        assertThat(list.size()).isEqualTo(3);

        list.deleteAtIndex(1);
        assertThat(list.size()).isEqualTo(2);

        assertThat(list.get(0)).isEqualTo(3);
        assertThat(list.get(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("add at index after adding at head")
    void testCase7() {
        list.addAtHead(5);
        list.addAtIndex(1, 2);
        assertThat(list.get(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("add at 1 when there's no elements")
    void testCase8() {
        list.addAtIndex(1, 0);
        assertThat(list.get(0)).isEqualTo(-1);
    }

    @Test
    @DisplayName("testing edge case")
    void testCase9() {
        list.addAtHead(2); // h -> 2
        list.deleteAtIndex(1); // h -> 2
        list.addAtHead(2); // h -> 2 -> 2
        list.addAtHead(7); // h -> 7 -> 2 -> 2
        list.addAtHead(3); // h -> 3 -> 7 -> 2 -> 2
        list.addAtHead(2); // h -> 2 -> 3 -> 7 -> 2 -> 2
        list.addAtHead(5); // h -> 5 -> 2 -> 3 -> 7 -> 2 -> 2
        list.addAtTail(5); // h -> 5 -> 2 -> 3 -> 7 -> 2 -> 2 -> 5
        assertThat(list.get(5)).isEqualTo(2);
        list.deleteAtIndex(6);
        list.deleteAtIndex(4);
    }
}