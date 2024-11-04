package com.adolfoeloy.graph;

public class DepthFirstSearchGraph implements GraphSearch {

    private final boolean[] markedVertices;
    private int count;

    public DepthFirstSearchGraph(Graph graph, int source) {
        this.markedVertices = new boolean[graph.vertices()];
        dfs(graph, source);
    }

    private void dfs(Graph graph, int v) {
        markedVertices[v] = true;
        count++;
        for (int w : graph.adjacentVertices(v)) {
            if (!markedVertices[w]) {
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean isMarked(int v) {
        return markedVertices[v];
    }

    @Override
    public int count() {
        return count;
    }
}
