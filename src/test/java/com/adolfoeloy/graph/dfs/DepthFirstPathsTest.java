package com.adolfoeloy.graph.dfs;

import com.adolfoeloy.graph.Graph;
import com.adolfoeloy.graph.GraphPath;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepthFirstPathsTest {

    @Test
    void pathShouldBeDeterminedByTheOrderOfEdgeCreation() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(5, 3);
        graph.addEdge(3, 4);

        GraphPath pathSearch = new DepthFirstPaths(graph, 0);

        assertThat(pathSearch.pathTo(4)).containsExactly(4, 2, 0);
    }

}