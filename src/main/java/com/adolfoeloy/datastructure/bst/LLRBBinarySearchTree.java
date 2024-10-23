package com.adolfoeloy.datastructure.bst;

import java.util.PriorityQueue;

/**
 * This class implements Left-leaning red black BST.
 * LLRB tree is generalisation on the idea of 2-3 trees data-structure which is a structure that aims to
 * keep the tree balanced as new nodes are added to the tree (solving the issue with ordered insertion into a regular BST).
 * The good thing is that for a RBBST all that changes is the insertion. All the other operations remain the same,
 * although they now have guaranteed O(n log n) time complexity.
 */
public class LLRBBinarySearchTree<Key extends Comparable<Key>, Value> implements BST<Key, Value> {
    private RBNode<Key, Value> root;

    @Override
    public void put(Key key, Value value) {
        // here is where things change for RB BST
    }

    @Override
    public int size() {
        return (root == null) ? 0 : root.count;
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

            n = min(t);
            n.right = deleteMin(t.right);
            n.left = t.left;
        }

        return n;
    }

    private RBNode<Key, Value> min(RBNode<Key, Value> n) {
        if (n == null) return null;
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
        return n;
    }

    @Override
    public Iterable<Key> iterator() {
        PriorityQueue<Key> pq = new PriorityQueue<>();
        inorder(root, pq);
        return pq;
    }

    private void inorder(RBNode<Key, Value> node, PriorityQueue<Key> pq) {
        if (node == null) return;
        inorder(node.left, pq);
        pq.add(node.key);
        inorder(node.right, pq);
    }

    private static class RBNode<Key, Value> {
        private Key key;
        private Value value;
        private Color color;
        private int count;
        private RBNode<Key, Value> left;
        private RBNode<Key, Value> right;

        boolean isRed() {
            return color == Color.RED;
        }
    }

    private enum Color {
        RED, BLACK
    }
}
