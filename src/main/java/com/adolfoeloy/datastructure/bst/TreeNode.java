package com.adolfoeloy.datastructure.bst;

public class TreeNode<Key, Value> {
    private final Key key;
    private Value value;
    private TreeNode<Key, Value> left;
    private TreeNode<Key, Value> right;

    public TreeNode(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public TreeNode<Key, Value> getLeft() {
        return left;
    }

    public TreeNode<Key, Value> getRight() {
        return right;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setLeft(TreeNode<Key, Value> node) {
        this.left = node;
    }

    public void setRight(TreeNode<Key, Value> right) {
        this.right = right;
    }
}
