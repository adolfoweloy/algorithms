package com.adolfoeloy.datastructure.bst;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> subject;

    @BeforeEach
    void setup() {
        subject = new BinarySearchTree<>();
    }

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

        assertThat(subject.inorderIterator()).containsExactly(
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
        assertThat(subject.inorderIterator()).containsExactly(
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
        assertThat(subject.inorderIterator()).containsExactly(
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
        assertThat(subject.inorderIterator()).containsExactly(
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
        assertThat(subject.inorderIterator()).containsExactly(
                20, 25, 30
        );
    }

    @Test
    @DisplayName("Testing rank")
    void testRank() {
        var subject2 = new BinarySearchTree<String, Integer>();
        subject2.put("S", 2);
        subject2.put("E", 5);
        subject2.put("A", 5);
        subject2.put("C", 5);
        subject2.put("R", 5);
        subject2.put("X", 5);
        subject2.put("H", 5);
        subject2.put("M", 5);

        // notice by examining the iterator printed following inorder traversal
        // there are 6 keys less than S, 5 keys less than R and 0 keys less than A
        assertThat(subject2.inorderIterator()).containsExactly(
                "A", "C", "E", "H", "M", "R", "S", "X"
        );

        assertThat(subject2.rank("S")).isEqualTo(6);
        assertThat(subject2.rank("R")).isEqualTo(5);
        assertThat(subject2.rank("A")).isEqualTo(0);
    }

    @Test
    void testInorderTraversal() {
        var subject2 = new BinarySearchTree<String, Integer>();
        subject2.put("S", 2);
        subject2.put("E", 5);
        subject2.put("A", 5);
        subject2.put("C", 5);
        subject2.put("R", 5);
        subject2.put("X", 5);
        subject2.put("H", 5);
        subject2.put("M", 5);

        assertThat(subject2.preorderIterator()).containsExactly(
                "S", "E", "A", "C", "R", "H", "M", "X"
        );
    }
}