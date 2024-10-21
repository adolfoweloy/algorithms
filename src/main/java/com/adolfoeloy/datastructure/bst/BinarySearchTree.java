package com.adolfoeloy.datastructure.bst;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private TreeNode<Key, Value> root;

    public void put(Key key, Value value) {
        var tmp = root;
        if (root == null) {
            root = new TreeNode<>(key, value);
        } else {
            insert(tmp, key, value);
        }
    }

    private void insert(TreeNode<Key, Value> node, Key key, Value value) {
        if (key.compareTo(node.getKey()) < 0) {
            if (node.getLeft() != null) {
                insert(node.getLeft(), key, value);
            } else {
                node.setLeft(new TreeNode<>(key, value));
            }
        } else if (key.compareTo(node.getKey()) > 0) {
            if (node.getRight() != null) {
                insert(node.getRight(), key, value);
            } else {
                node.setRight(new TreeNode<>(key, value));
            }
        } else {
            node.setValue(value);
        }
    }

    public Value get(Key key) {
        var tmp = root;
        return search(tmp, key);
    }

    private Value search(TreeNode<Key, Value> node, Key key) {
        if (node == null) return null;
        if (key.compareTo(node.getKey()) < 0) {
            return search(node.getLeft(), key);
        } else if (key.compareTo(node.getKey()) > 0) {
            return search(node.getRight(), key);
        } else {
            return node.getValue();
        }
    }

    public void delete(Key key) {
        // TODO
    }

    public Iterable<Key> iterator() {
        // TODO
        return null;
    }
}
