package com.adolfoeloy.graph;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private int vertices;
    private int edges;
    private Set<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Graph(int vertices) {
        this.vertices = vertices;

        // initialise the adjacency lists
        adj = (Set<Integer>[]) new Set[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new HashSet<>();
        }
    }

    /**
     * Number of vertices.
     */
    int vertices() {
        return vertices;
    }

    /**
     * Number of edges.
     */
    int edges() {
        return edges;
    }

    /**
     * Add edge v-w to this graph.
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    /**
     * Vertices adjacent to v.
     */
    Iterable<Integer> adjacentVertices(int v) {
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

    /**
     * Compute the vertex with most adjacent vertices and return its degree.
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.vertices(); v++) {
            max = Math.max(degree(G, v), max);
        }
        return max;
    }

    public static int avgDegree(Graph G) {
        return 2 * G.edges() / G.vertices();
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
