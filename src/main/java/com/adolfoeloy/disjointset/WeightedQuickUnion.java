package com.adolfoeloy.disjointset;

public class WeightedQuickUnion implements UnionFind {
    private final int[] ids;
    private final int[] sizes;

    WeightedQuickUnion(int n) {
        ids = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    @Override
    public int find(int i) {
        while (i != ids[i]) i = ids[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        var pid = find(p);
        var qid = find(q);
        if (sizes[pid] < sizes[qid]) {
            ids[pid] = qid;
            sizes[qid] += sizes[pid];
        } else {
            ids[qid] = pid;
            sizes[pid] += sizes[qid];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
