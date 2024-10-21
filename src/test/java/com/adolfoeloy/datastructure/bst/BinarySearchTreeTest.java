package com.adolfoeloy.datastructure.bst;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

    private final BinarySearchTree<Integer, String> subject =
            new BinarySearchTree<>();

    @Test
    @DisplayName("Testing get/put operations")
    void test1() {
        subject.put(1, "Adolfo");
        assertThat(subject.size()).isEqualTo(1);

        subject.put(12, "Hannah");
        assertThat(subject.size()).isEqualTo(2);

        subject.put(2, "Janine");
        assertThat(subject.size()).isEqualTo(3);

        subject.put(10, "Isaac");
        assertThat(subject.size()).isEqualTo(4);

        assertThat(subject.get(1)).isEqualTo("Adolfo");
        assertThat(subject.get(2)).isEqualTo("Janine");
        assertThat(subject.get(10)).isEqualTo("Isaac");
        assertThat(subject.get(12)).isEqualTo("Hannah");
    }

    @Test
    @DisplayName("Testing the sorted iterable")
    void test2() {
        subject.put(1, "Adolfo");
        subject.put(12, "Hannah");
        subject.put(2, "Janine");
        subject.put(10, "Isaac");

        Assertions.assertThat(subject.iterator()).containsExactly(
                1, 2, 10, 12
        );
    }
}