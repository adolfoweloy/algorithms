package com.adolfoeloy.tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorGenericTree {

    <T> GenericTreeNode<T> search(GenericTreeNode<T> root, Set<GenericTreeNode<T>> query) {
        return search(root, query, new HashSet<>());
    }

    private <T> GenericTreeNode<T> search(
            GenericTreeNode<T> root,
            Set<GenericTreeNode<T>> query,
            HashSet<GenericTreeNode<T>> itemsFound
    ) {
        if (root == null) return null;
        if (query.contains(root)) return root;

        for (var param : root.children()) {
            var result = search(param, query);
            if (result != null) itemsFound.add(param);
        }

        if (itemsFound.equals(query)) return root;

        return itemsFound.stream().findFirst().orElse(null);
    }

}
