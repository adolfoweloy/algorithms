package com.adolfoeloy.datastructure.bst;

public interface TreeNode<Key, Value> {
    Key getKey();

    Value getValue();

    TreeNode<Key, Value> getLeft();

    TreeNode<Key, Value> getRight();

    int getCount();
}
