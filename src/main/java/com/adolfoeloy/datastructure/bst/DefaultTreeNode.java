package com.adolfoeloy.datastructure.bst;

public class DefaultTreeNode<Key, Value> implements TreeNode<Key, Value> {
    private final Key key;
    private Value value;
    private int count;
    private DefaultTreeNode<Key, Value> left;
    private DefaultTreeNode<Key, Value> right;

    public DefaultTreeNode(Key key, Value value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
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
    public DefaultTreeNode<Key, Value> getLeft() {
        return left;
    }

    @Override
    public DefaultTreeNode<Key, Value> getRight() {
        return right;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setLeft(DefaultTreeNode<Key, Value> node) {
        this.left = node;
    }

    public void setRight(DefaultTreeNode<Key, Value> right) {
        this.right = right;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
