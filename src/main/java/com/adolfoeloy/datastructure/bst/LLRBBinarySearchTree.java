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
        // hibbard deletion is not easy /o\

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
