package com.adolfoeloy.disjointset;

/**
 * Initialise = O(N)
 * Union      = O(N)
 * Find       = O(1)
 * Notes: N union commands on N objects, will take O(N^2) time. Unacceptable!
 */
public class QuickFind implements UnionFind {
    private final int[] id;

    QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public int find(int n) {
        return id[n];
    }

    @Override
    public void union(int p, int q) {
        var pid = id[p];
        var qid = id[q];

        // if both are connected, return
        if (pid == qid) return;

        // quick find can find connections at O(1) time
        // however the union operation is O(N) since there's the need to go through all elements of root.
        // every node that is connected with B will now be connected to A
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean isConnected(int a, int b) {
        return id[a] == id[b];
    }
}
