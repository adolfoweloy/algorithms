package com.adolfoeloy.graph;

public class Graph {
    private int vertices;
    private int edges;

    Graph(int vertices) {
        this.vertices = vertices;
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
    Iterable<Integer> adjacentVertices(int v) {
        return null;
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
