package com.adolfoeloy.datastructure.bst;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private TreeNode<Key, Value> root;

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // time complexity average path when keys come in random order O(~2 + ln N)
    // if keys come in order, or in natural order, that leads the data-structure to the worst case
    // where all keys are added to the left or all added to the right leading search operations to O(N).
    // if the tree was balanced, this could be achieved in O(log n)
    private TreeNode<Key, Value> put(TreeNode<Key, Value> node, Key key, Value value) {
        if (node == null) return new TreeNode<>(key, value);
        var cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeft(put(node.getLeft(), key, value));
        } else if (cmp > 0) {
            node.setRight(put(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }
        return node;
    }

    // time complexity O(1 + depth of the tree)
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

    public void delete(Key key) {
        // TODO
    }

    public Iterable<Key> iterator() {
        // TODO
        return null;
    }
}
