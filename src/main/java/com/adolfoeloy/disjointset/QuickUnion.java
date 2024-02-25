package com.adolfoeloy.disjointset;

/**
 * Initialise = O(N)
 * Union      = O(N) -> actually the tree height
 * Find       = O(N) -> actually the tree height
 * Notes: N union commands on N objects, will take O(N^2) time. Unacceptable!
 */
public class QuickUnion implements UnionFind {
    private final int[] ids;

    QuickUnion(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) ids[i] = i;
    }

    @Override
    public int find(int i) {
        while (ids[i] != i) i = ids[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        // find the root of both
        int pid = find(p);
        int qid = find(q);
        // link the root of p to the root of q
        ids[qid] = pid;
    }

    @Override
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
