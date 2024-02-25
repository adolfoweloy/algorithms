package com.adolfoeloy.disjointset;

public interface UnionFind {

    // finds the parent or root of n
    int find(int n);

    // connects a and b
    void union(int q, int p);

    // checks if a is connected with b
    boolean isConnected(int q, int p);

}
