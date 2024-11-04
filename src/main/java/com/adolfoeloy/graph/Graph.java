package com.adolfoeloy.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int vertices;
    private int edges;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;

        // initialise the adjacency lists
        adj = (List<Integer>[]) new List[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    /**
     * Number of vertices.
     */
    public int vertices() {
        return vertices;
    }

    /**
     * Number of edges.
     */
    public int edges() {
        return edges;
    }

    /**
     * Add edge v-w to this graph.
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    /**
     * Vertices adjacent to v.
     */
    public Iterable<Integer> adjacentVertices(int v) {
        return adj[v];
    }

    /**
     * Compute the degree of vertex v.
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adjacentVertices(v)) degree++;
        return degree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d vertices, %d edges\n", vertices, edges));
        for (int v = 0; v < vertices; v++) {
            sb.append(v); sb.append(": ");
            for (int w: this.adjacentVertices(v)) {
                sb.append(w); sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
