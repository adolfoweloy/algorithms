package com.adolfoeloy.tree;

import java.util.List;

public record GenericTreeNode<T>(
        T value,
        List<GenericTreeNode<T>> children
) {

    static <T> GenericTreeNode<T> node(T value) {
        return new GenericTreeNode<>(value, List.of());
    }

    static <T> GenericTreeNode<T> node(T value, List<GenericTreeNode<T>> children) {
        return new GenericTreeNode<>(value, children);
    }
}
