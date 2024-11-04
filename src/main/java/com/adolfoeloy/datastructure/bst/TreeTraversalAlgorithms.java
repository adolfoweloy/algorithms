package com.adolfoeloy.datastructure.bst;

import java.util.List;

public class TreeTraversalAlgorithms<Key, Value> {

    public void inorder(List<Key> list, TreeNode<Key,Value> node) {
        if (node == null) return;
        inorder(list, node.getLeft());
        list.add(node.getKey());
        inorder(list, node.getRight());
    }

    public void preorder(List<Key> list, TreeNode<Key,Value> node) {
        if (node == null) return;
        list.add(node.getKey());
        preorder(list, node.getLeft());
        preorder(list, node.getRight());
    }

}
