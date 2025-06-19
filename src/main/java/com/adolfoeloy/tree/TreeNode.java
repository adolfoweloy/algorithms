package com.adolfoeloy.tree;

import java.util.Objects;

public class TreeNode {

    Integer value;
    TreeNode left;
    TreeNode right;

    TreeNode(
        int value
    ) {
        this.value = value;
    }

    TreeNode(
            int value,
            TreeNode left,
            TreeNode right
    ) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TreeNode other)) return false;

        return this.value == other.value &&
                Objects.equals(this.left, other.left) &&
                Objects.equals(this.right, other.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}
