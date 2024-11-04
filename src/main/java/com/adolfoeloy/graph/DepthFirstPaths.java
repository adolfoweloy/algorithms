package com.adolfoeloy.graph;

import java.util.Stack;

public class DepthFirstPaths implements GraphPath {
    private boolean[] marked; // visited vertices
    private int[] edgeTo;     // saves the parent or previously visited vertex.
    private final int s;      // source vertex

    public DepthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adjacentVertices(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return new Stack<>();

        Stack<Integer> r = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            r.push(w);
        }
        r.push(s);

        return r;
    }
}
