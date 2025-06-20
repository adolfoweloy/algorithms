package com.adolfoeloy.tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorGenericTree {

    <T> GenericTreeNode<T> search(GenericTreeNode<T> root, Set<GenericTreeNode<T>> query) {
        if (root == null) return null;
        if (query.contains(root)) return root;

        var results = new HashSet<GenericTreeNode<T>>();
        for (var param : root.children()) {
            var result = search(param, query);
            if (result != null) results.add(result);
        }

        if (results.equals(query)) return root;

        return results.stream().findFirst().orElse(null);
    }

}
