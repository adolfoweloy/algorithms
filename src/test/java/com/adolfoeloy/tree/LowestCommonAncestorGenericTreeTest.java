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
        var p = new GenericTreeNode<>(2, List.of());
        var q = new GenericTreeNode<>(3, List.of());
        var root = new GenericTreeNode<>(1, List.of(p, q));

        var result = subject.search(root, Set.of(p, q));

        assertThat(result).isEqualTo(root);
    }

    @Test
    void shouldFindLowestCommonAncestorWithOneEntryAsLCA() {
        var p = new GenericTreeNode<>(2, List.of());
        var q = new GenericTreeNode<>(3, List.of());
        var root = new GenericTreeNode<>(1, List.of(p, q));

        var result = subject.search(root, Set.of(root, p));

        assertThat(result).isEqualTo(root);
    }

    @Test
    void shouldFindLowestCommonAncestorOfThreeEntriesInQuery() {
        var p = node(9);
        var q = node(10);
        var r = node(13);

        var parent = node(2, List.of(
                node(4),
                node(8, List.of(p)),
                node(5, List.of(
                        q,
                        node(11),
                        node(12, List.of(r))
                ))
        ));

        var root = node(
                1, List.of(
                        parent,
                        node(3, List.of(
                                node(6),
                                node(7)
                        ))
                ));

        var result = subject.search(root, Set.of(p, q, r));

        assertThat(result).isEqualTo(parent);
    }
}