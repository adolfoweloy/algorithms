package com.adolfoeloy.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LowestCommonAncestorTest {

    private final LowestCommonAncestor subject = new LowestCommonAncestor();

    @Test
    void shouldFindCommonAncestorAtSameLevel() {
        var root = TreeNodeFactory.create(new Integer[]{1, 2, 3});

        var p = new TreeNode(2, null, null);
        var q = new TreeNode( 3, null, null);

        var r = subject.solve(root, p, q);

        assertThat(r).isEqualTo(root);
        assertThat(r.value).isEqualTo(1);
    }

    @Test
    void shouldFindCommonAncestorWhenPIsSameAsRoot() {
        var root = TreeNodeFactory.create(new Integer[] {1, 2, 3, 4, 5});

        var p = root;
        var q = new TreeNode( 4, null, null);

        var r = subject.solve(root, p, q);

        assertThat(r).isEqualTo(root);
        assertThat(r.value).isEqualTo(1);
    }
}