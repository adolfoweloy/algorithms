package com.adolfoeloy.datastructure.bst;

import java.util.PriorityQueue;

/**
 * This Binary search tree (BST) implements a symbol table.
 * An elementary implementation for symbol tables can be done with linked lists, however BST improves the execution time
 * for operations in the symbol table.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements BST<Key, Value> {
    private TreeNode<Key, Value> root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // time complexity average path when keys come in random order O(~2 + ln N)
    // if keys come in order, or in natural order, that leads the data-structure to the worst case
    // where all keys are added to the left or all added to the right leading search operations to O(N).
    // if the tree was balanced, this could be achieved in O(log n)
    private TreeNode<Key, Value> put(TreeNode<Key, Value> node, Key key, Value value) {
        if (node == null) return new TreeNode<>(key, value, 1);
        var cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeft(put(node.getLeft(), key, value));
        } else if (cmp > 0) {
            node.setRight(put(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }
        node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(TreeNode<Key, Value> node) {
        if (node == null) return 0;
        return node.getCount();
    }

    // time complexity O(1 + depth of the tree)
    @Override
    public Value get(Key key) {
        var tmp = root;
        while (tmp != null) {
            var cmp = key.compareTo(tmp.getKey());
            if (cmp < 0) tmp = tmp.getLeft();
            else if (cmp > 0) tmp = tmp.getRight();
            else return tmp.getValue();
        }
        return null;
    }

    // implemented with Hibbard's algorithm with time complexity of O(sqrt(N))
    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    // if put/delete with random values for long time enough, one will notice that
    // the structure tends to become unbalanced impacting performance for all other operations.
    private TreeNode<Key, Value> delete(TreeNode<Key, Value> node, Key key) {
        if (node == null) return null;
        // first search the key
        var cmp = key.compareTo(node.getKey());
        if (cmp < 0) node.setLeft(delete(node.getLeft(), key));
        else if (cmp > 0) node.setRight(delete(node.getRight(), key));
        else {
            // then when the node is found, do the deletion logic
            // the two cases below are the easiest ones which are the cases where the node
            // has only one child.
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            // the trickiest part is when there are two children
            // find the node t that contains our key
            var t = node;

            // find the smallest node on the right subtree
            // delete that node     8
            node = min(t.getRight());
            node.setRight(deleteMin(t.getRight()));
            node.setLeft(t.getLeft());
        }
        node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    private TreeNode<Key, Value> min(TreeNode<Key, Value> node) {
        if (node == null) return null;
        if (node.getLeft() == null) return node;
        return min(node.getLeft());
    }

    @Override
    public void deleteMin() {
        if (root == null) throw new IllegalStateException("The BST is empty");
        root = deleteMin(root);
    }

    private TreeNode<Key, Value> deleteMin(TreeNode<Key, Value> node) {
        if (node.getLeft() == null) return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        node.setCount(1 + size(node.getLeft()) + size(node.getRight()));
        return node;
    }

    @Override
    public Iterable<Key> iterator() {
        PriorityQueue<Key> queue = new PriorityQueue<>();
        inorder(queue, root);
        return queue;
    }

    private void inorder(PriorityQueue<Key> queue, TreeNode<Key, Value> node) {
        if (node == null) return;
        inorder(queue, node.getLeft());
        queue.add(node.getKey());
        inorder(queue, node.getRight());
    }
}
