package com.adolfoeloy.tree;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static com.adolfoeloy.tree.GenericTreeNode.node;
import static org.assertj.core.api.Assertions.assertThat;

class LowestCommonAncestorGenericTreeTest {

    private final LowestCommonAncestorGenericTree subject = new LowestCommonAncestorGenericTree();

    @Test
    void shouldFindLowestCommonAncestorOfTwoEntriesInQuery() {
        var p = node(2);
        var q = node(3);
        var root = node(1, List.of(p, q));

        var result = subject.search(root, Set.of(p, q));

        assertThat(result).isEqualTo(root);
    }

    @Test
    void shouldFindLowestCommonAncestorWithOneEntryAsLCA() {
        var p = node(2);
        var q = node (3);
        var root = node(1, List.of(p, q));

        var result = subject.search(root, Set.of(root, p));

        assertThat(result).isEqualTo(root);
    }

    @Test
    void shouldFindRootAsLCAWhenQueryNodesAreInSeparateSubtrees() {
        var node5 = node(5);
        var node2 = node(2);
        var node3 = node(3, List.of(node5));
        var root = node(1, List.of(node2, node3));

        var result = subject.search(root, Set.of(node2, node5));

        assertThat(result).isEqualTo(root);
    }

    @Test
    void shouldFindDeepestCommonAncestorBetweenTwoSiblings() {
        var node5 = node(5);
        var node6 = node(6);
        var node3 = node(3, List.of(node5, node6));
        var root = node(1, List.of(node3));

        var result = subject.search(root, Set.of(node5, node6));

        assertThat(result).isEqualTo(node3);
    }

    @Test
    void shouldFindLowestCommonAncestorOfThreeEntriesInQuery() {
        // nodes to be queried
        var p = node(9);
        var q = node(10);
        var r = node(13);

        // intermediate nodes
        var node4 = node(4);
        var node8 = node(8, List.of(p));
        var node11 = node(11);
        var node12 = node(12, List.of(r));
        var node5 = node(5, List.of(q, node11, node12));

        var node2 = node(2, List.of(node4, node8, node5));
        var node6 = node(6);
        var node7 = node(7);
        var node3 = node(3, List.of(node7, node6));

        var root = node(1, List.of(node2, node3));

        var result = subject.search(root, Set.of(p, q, r));

        assertThat(result).isEqualTo(node2);
    }

    @Test
    void shouldFindLowestCommonAncestorBetweenTwoSiblings() {
        var node8 = node(8);
        var node9 = node(9);
        var node4 = node(4, List.of(node8, node9));
        var node5 = node(5);
        var node6 = node(6);
        var node7 = node(7);
        var node2 = node(2, List.of(node4, node5));
        var node3 = node(3, List.of(node6, node7));
        var root = node(1, List.of(node2, node3));

        var result = subject.search(root, Set.of(node4, node5));

        assertThat(result).isEqualTo(node2);
    }

}