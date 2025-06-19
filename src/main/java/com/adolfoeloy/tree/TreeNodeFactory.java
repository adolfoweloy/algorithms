package com.adolfoeloy.tree;

/**
 * Creates a binary tree using a heap like array representation for a tree.
 */
public class TreeNodeFactory {

    TreeNode create(Integer[] input) {
        if (input.length == 0) return null;

        return buildNode(input, 0);
    }

    private TreeNode buildNode(Integer[] a, int k) {
        if (k >= a.length) return null;
        if (a[k] == null) return null;

        var result = new TreeNode(a[k]);

        int left = 2 * k + 1;
        int right = 2 * k + 2;
        result.left = buildNode(a, left);
        result.right = buildNode(a, right);

        return result;
    }
}
