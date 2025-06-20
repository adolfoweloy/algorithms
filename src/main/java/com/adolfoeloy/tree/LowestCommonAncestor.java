package com.adolfoeloy.tree;

public class LowestCommonAncestor {

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.equals(p) || root.equals(q)) return root;

        var left = solve(root.left, p, q);
        var right = solve(root.right, p, q);

        // if there's no duplicates, find results from both left and right
        // must be the outcome of finding both p and q because p and q
        // won't exist both on the left side. Unless, the root is the node being
        // searched, which is already solved by (root == p || root == q)
        if (left != null && right != null) {
            return root;
        }

        // what happens if p or q were found in only one side?
        if (left != null) return left;
        else return right;
    }

}
