package com.adolfoeloy.graph;

public class Graph {
    Graph(int vertices) {

    }

    /**
     * Number of vertices.
     */
    int vertices() {
        return 0;
    }

    /**
     * Number of edges.
     */
    int edges() {
        return 0;
    }

    /**
     * Add edge v-w to this graph.
     */
    void addEdge(int v, int w) {

    }

    /**
     * Vertices adjacent to v.
     */
    Iterable<Integer> adjacency(int v) {
        return null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Graph{");
        sb.append('}');
        return sb.toString();
    }
}
