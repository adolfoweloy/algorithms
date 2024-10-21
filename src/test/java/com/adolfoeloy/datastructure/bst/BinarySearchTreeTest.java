package com.adolfoeloy.datastructure.bst;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

    private final BinarySearchTree<Integer, String> subject =
            new BinarySearchTree<>();

    @Test
    void test1() {
        subject.put(1, "Adolfo");
        subject.put(12, "Hannah");
        subject.put(2, "Janine");
        subject.put(10, "Isaac");

        assertThat(subject.get(1)).isEqualTo("Adolfo");
        assertThat(subject.get(2)).isEqualTo("Janine");
        assertThat(subject.get(10)).isEqualTo("Isaac");
        assertThat(subject.get(12)).isEqualTo("Hannah");
    }
}