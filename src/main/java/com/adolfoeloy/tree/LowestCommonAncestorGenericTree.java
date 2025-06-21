package com.adolfoeloy.tree;

import java.util.Set;

public class LowestCommonAncestorGenericTree {

    private static class Result<T> {
        GenericTreeNode<T> lca;
        int count;

        Result(GenericTreeNode<T> lca, int count) {
            this.lca = lca;
            this.count = count;
        }
    }

    <T> GenericTreeNode<T> search(GenericTreeNode<T> root, Set<GenericTreeNode<T>> query) {
        return searchHelper(root, query).lca;
    }

    private <T> Result<T> searchHelper(
            GenericTreeNode<T> root,
            Set<GenericTreeNode<T>> query
    ) {
        if (root == null) return new Result<>(null, 0);
        int total = query.contains(root) ? 1 : 0;

        for (var child : root.children()) {
            var result = searchHelper(child, query);
            if (result.lca != null) return result;
            total += result.count;
        }

        if (total == query.size()) return new Result<>(root, total);

        return new Result<>(null, total);
    }

}
