package com.adolfoeloy.datastructure.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements Left-leaning red black BST.
 * LLRB tree is generalisation on the idea of 2-3 trees data-structure which is a structure that aims to
 * keep the tree balanced as new nodes are added to the tree (solving the issue with ordered insertion into a regular BST).
 * The good thing is that for a RBBST all that changes is the insertion. All the other operations remain the same,
 * although they now have guaranteed O(n log n) time complexity.
 */
public class LLRBBinarySearchTree<Key extends Comparable<Key>, Value> implements BST<Key, Value> {
    private final TreeTraversalAlgorithms<Key, Value> traversal = new TreeTraversalAlgorithms<>();
    private RBNode<Key, Value> root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private RBNode<Key, Value> put(RBNode<Key, Value> node, Key key, Value value) {
        if (node == null) {
            var newNode = new RBNode<>(key, value, 1);

            // this is what changes when returning a new node
            newNode.color = Color.RED;
            return newNode;
        }


        // the search and replacement part remains exactly the same
        var cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        // and here is the logic to re-balance the tree
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node); // lean left
        // situation where a new node is added to a red node on the left
        // and that will transform the tree into a two red children that will be fixed in the next step with flipColors
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node); // split 4-node

        // same from standard BST
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private boolean isRed(RBNode<Key, Value> node) {
        if (node == null) return false;
        return node.isRed();
    }

    private void flipColors(RBNode<Key,Value> node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    private RBNode<Key,Value> rotateLeft(RBNode<Key,Value> node) {
        var tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        tmp.color = node.color;
        node.color = Color.RED;

        node.count = 1 + size(node.left) + size(node.right);
        return tmp;
    }

    private RBNode<Key, Value> rotateRight(RBNode<Key, Value> node) {
        var tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        tmp.color = node.color;
        node.color = Color.RED;

        node.count = 1 + size(node.left) + size(node.right);
        return tmp;
    }

    @Override
    public int size() {
        return (root == null) ? 0 : root.count;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, RBNode<Key, Value> node) {
        if (node == null) return 0;

        var cmp = key.compareTo(node.key);

        if (cmp < 0) return rank(key, node.left);
        else if (cmp > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left);
    }

    private int size(RBNode<Key, Value> node) {
        if (node == null) return 0;
        return node.count;
    }

    @Override
    public Value get(Key key) {
        // the logic is pretty much the same from BST
        var tmp = root;
        while (tmp != null) {
            var cmp = key.compareTo(tmp.key);
            if (cmp < 0) tmp = tmp.left;
            else if (cmp > 0) tmp = tmp.right;
            else return tmp.value;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private RBNode<Key, Value> delete(RBNode<Key, Value> n, Key key) {
        if (n == null) return null;

        var cmp = key.compareTo(n.key);
        if (cmp < 0) n.left = delete(n.left, key);
        else if (cmp > 0) n.right = delete(n.right, key);
        else {
            if (n.left == null) return n.right;
            if (n.right == null) return n.left;

            var t = n;

            n = min(t.right);
            n.right = deleteMin(t.right);
            n.left = t.left;

        }

        n.count = 1 + size(n.left) + size(n.right);
        return n;
    }

    private RBNode<Key, Value> min(RBNode<Key, Value> n) {
        if (n.left == null) return n;
        return min(n.left);
    }

    @Override
    public void deleteMin() {
        if (root == null)  throw new IllegalStateException("The BST is empty");
        root = deleteMin(root);
    }

    private RBNode<Key, Value> deleteMin(RBNode<Key, Value> n) {
        if (n.left == null) return n.right;
        n.left = deleteMin(n.left);
        n.count = 1 + size(n.left) + size(n.right);
        return n;
    }

    @Override
    public Iterable<Key> inorderIterator() {
        List<Key> list = new ArrayList<>();
        traversal.inorder(list, root);
        return list;
    }

    @Override
    public Iterable<Key> preorderIterator() {
        List<Key> list = new ArrayList<>();
        traversal.preorder(list, root);
        return list;
    }

    private static class RBNode<Key, Value> implements TreeNode<Key, Value> {
        private final Key key;
        private Value value;
        private Color color;
        private int count;
        private RBNode<Key, Value> left;
        private RBNode<Key, Value> right;

        RBNode(Key key, Value value,  int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }

        boolean isRed() {
            return color == Color.RED;
        }

        @Override
        public Key getKey() {
            return key;
        }

        @Override
        public Value getValue() {
            return value;
        }

        @Override
        public TreeNode<Key, Value> getLeft() {
            return left;
        }

        @Override
        public TreeNode<Key, Value> getRight() {
            return right;
        }

        @Override
        public int getCount() {
            return count;
        }
    }

    private enum Color {
        RED, BLACK
    }
}
