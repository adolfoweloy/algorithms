package com.adolfoeloy.disjointset;

public class QuickFind implements UnionFind {
    private final int[] root;

    QuickFind(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    @Override
    public int find(int n) {
        return root[n];
    }

    @Override
    public void union(int a, int b) {
        var r = root[b];
        // if both are connected, return
        if (root[a] == root[b]) return;

        // quick find can find connections at O(1) time
        // however the connect is be O(N) since there's the need to go through all elements of root.
        for (int i = 0; i < root.length; i++) {
            if (root[i] == r) {
                root[i] = root[a];
            }
        }
    }

    @Override
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
