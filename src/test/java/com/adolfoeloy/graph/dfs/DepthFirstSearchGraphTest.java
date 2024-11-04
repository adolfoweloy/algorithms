package com.adolfoeloy.graph.dfs;

import com.adolfoeloy.graph.Graph;
import com.adolfoeloy.graph.GraphSearch;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Using the current available API to determine if a graph is connected or not.
 */
class DepthFirstSearchGraphTest {

    @Test
    void shouldCreateANonConnectedGraph() {
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);

        GraphSearch search = new DepthFirstSearchGraph(graph, 0);
        assertThat(search.count()).isNotEqualTo(graph.vertices());
    }

    @Test
    void shouldCreateAConnectedGraph() {
        Graph graph = new Graph(4);

        graph.addEdge(2, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);

        GraphSearch search = new DepthFirstSearchGraph(graph, 0);
        assertThat(search.count()).isEqualTo(graph.vertices());
    }
}