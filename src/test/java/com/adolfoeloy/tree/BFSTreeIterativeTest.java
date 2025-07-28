package com.adolfoeloy.tree;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BFSTreeIterativeTest {

    @Test
    void testLevelsWithBalancedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BFSTreeIterative bfsTreeIterative = new BFSTreeIterative();
        List<List<Integer>> result = bfsTreeIterative.levels(root);

        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo(List.of(1));
        assertThat(result.get(1)).isEqualTo(List.of(2, 3));
        assertThat(result.get(2)).isEqualTo(List.of(4, 5, 6, 7));
    }

    @Test
    void testLevelsWithSingleNode() {
        TreeNode root = new TreeNode(1);

        BFSTreeIterative bfsTreeIterative = new BFSTreeIterative();
        List<List<Integer>> result = bfsTreeIterative.levels(root);

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(List.of(1));
    }

    @Test
    void testLevelsWithEmptyTree() {
        BFSTreeIterative bfsTreeIterative = new BFSTreeIterative();
        List<List<Integer>> result = bfsTreeIterative.levels(null);

        assertThat(result).isEmpty();
    }
}