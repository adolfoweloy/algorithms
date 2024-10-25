package com.adolfoeloy.datastructure.bst;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LLRBBinarySearchTreeTest {

    private LLRBBinarySearchTree<Integer, String> subject =
            new LLRBBinarySearchTree<>();

    @Test
    @DisplayName("Testing get/put operations")
    void test1() {
        subject = new LLRBBinarySearchTree<>();
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

        assertThat(subject.iterator()).containsExactly(
                1, 2, 10, 12
        );
    }

    @Test
    @DisplayName("Delete min where min has no child on the right")
    void test3() {
        subject.put(3, "Adolfo");
        subject.put(2, "Hannah");
        subject.put(4, "Janine");
        subject.put(10, "Isaac");
        assertThat(subject.size()).isEqualTo(4);

        subject.deleteMin();

        assertThat(subject.size()).isEqualTo(3);
        assertThat(subject.iterator()).containsExactly(
                3, 4, 10
        );
    }

    @Test
    @DisplayName("Delete min where min has child on the right")
    void test4() {
        subject.put(30, "Adolfo");
        subject.put(20, "Hannah");
        subject.put(40, "Janine");
        subject.put(25, "Isaac");
        assertThat(subject.size()).isEqualTo(4);

        subject.deleteMin();

        assertThat(subject.size()).isEqualTo(3);
        assertThat(subject.iterator()).containsExactly(
                25, 30, 40
        );
    }

    @Test
    @DisplayName("Delete min where the root node has only right child")
    void test5() {
        subject.put(30, "Adolfo");
        subject.put(40, "Janine");
        assertThat(subject.size()).isEqualTo(2);

        subject.deleteMin();

        assertThat(subject.size()).isEqualTo(1);
        assertThat(subject.iterator()).containsExactly(
                40
        );
    }

    @Test
    @DisplayName("Delete min from empty BST should throw exception")
    void test6() {
        Assertions.assertThatThrownBy(subject::deleteMin)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("Testing deletion by key")
    void test7() {
        subject.put(30, "Adolfo");
        subject.put(20, "Hannah");
        subject.put(40, "Janine");
        subject.put(25, "Isaac");
        assertThat(subject.size()).isEqualTo(4);

        subject.delete(40);

        assertThat(subject.size()).isEqualTo(3);
        assertThat(subject.iterator()).containsExactly(
                20, 25, 30
        );
    }
}