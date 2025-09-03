package com.adolfoeloy.graph.bfs;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class CloneGraphTest {

    @Test
    public void testCloneGraph_case1() {
        // Input: [[2,4],[1,3],[2,4],[1,3]]
        int[][] adjList = {{2,4},{1,3},{2,4},{1,3}};
        CloneGraph.Node original = GraphTestUtil.buildGraphFromAdjList(adjList);

        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node cloned = cloneGraph.cloneGraph(original);

        // Verify the cloned graph has the same structure
        int[][] expectedAdjList = {{2,4},{1,3},{2,4},{1,3}};
        assertThat(GraphTestUtil.graphToAdjList(cloned)).isEqualTo(expectedAdjList);

        // Verify it's a deep copy (different object references)
        assertThat(cloned).isNotSameAs(original);
        GraphTestUtil.verifyDeepCopy(original, cloned);
    }

    @Test
    public void testCloneGraph_case2() {
        // Input: [[]]
        int[][] adjList = {{}};
        CloneGraph.Node original = GraphTestUtil.buildGraphFromAdjList(adjList);

        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node cloned = cloneGraph.cloneGraph(original);

        // Verify the cloned graph has the same structure
        int[][] expectedAdjList = {{}};
        assertThat(GraphTestUtil.graphToAdjList(cloned)).isEqualTo(expectedAdjList);

        // Verify it's a deep copy
        assertThat(cloned).isNotSameAs(original);
        assertThat(cloned.val).isEqualTo(1);
        assertThat(cloned.neighbors).isEmpty();
    }

    @Test
    public void testCloneGraph_case3() {
        // Input: []
        CloneGraph.Node original = null;

        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node cloned = cloneGraph.cloneGraph(original);

        // Verify null input returns null
        assertThat(cloned).isNull();
    }

    /**
     * Utility class to help with graph testing operations
     */
    static class GraphTestUtil {

        /**
         * Builds a graph from adjacency list representation.
         * The adjacency list is 1-indexed as per LeetCode convention.
         */
        public static CloneGraph.Node buildGraphFromAdjList(int[][] adjList) {
            if (adjList == null || adjList.length == 0) {
                return null;
            }

            CloneGraph cloneGraph = new CloneGraph();
            Map<Integer, CloneGraph.Node> nodeMap = new HashMap<>();

            // Create all nodes first
            for (int i = 0; i < adjList.length; i++) {
                nodeMap.put(i + 1, cloneGraph.new Node(i + 1));
            }

            // Connect neighbors
            for (int i = 0; i < adjList.length; i++) {
                CloneGraph.Node currentNode = nodeMap.get(i + 1);
                for (int neighborVal : adjList[i]) {
                    currentNode.neighbors.add(nodeMap.get(neighborVal));
                }
            }

            return nodeMap.get(1);
        }

        /**
         * Converts a graph starting from given node to adjacency list representation.
         * Returns the adjacency list in the same format as LeetCode input.
         */
        public static int[][] graphToAdjList(CloneGraph.Node startNode) {
            if (startNode == null) {
                return new int[0][];
            }

            Map<CloneGraph.Node, Integer> nodeToIndex = new HashMap<>();
            List<CloneGraph.Node> nodes = new ArrayList<>();

            // BFS to discover all nodes
            Queue<CloneGraph.Node> queue = new LinkedList<>();
            Set<CloneGraph.Node> visited = new HashSet<>();

            queue.offer(startNode);
            visited.add(startNode);

            while (!queue.isEmpty()) {
                CloneGraph.Node current = queue.poll();
                nodes.add(current);
                nodeToIndex.put(current, current.val);

                for (CloneGraph.Node neighbor : current.neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }

            // Sort nodes by their values to ensure consistent output
            nodes.sort((a, b) -> Integer.compare(a.val, b.val));

            // Build adjacency list
            int[][] adjList = new int[nodes.size()][];
            for (int i = 0; i < nodes.size(); i++) {
                CloneGraph.Node node = nodes.get(i);
                List<Integer> neighborValues = new ArrayList<>();

                for (CloneGraph.Node neighbor : node.neighbors) {
                    neighborValues.add(neighbor.val);
                }

                neighborValues.sort(Integer::compareTo);
                adjList[i] = neighborValues.stream().mapToInt(Integer::intValue).toArray();
            }

            return adjList;
        }

        /**
         * Verifies that the cloned graph is a deep copy of the original.
         * Checks that no node objects are shared between the two graphs.
         */
        public static void verifyDeepCopy(CloneGraph.Node original, CloneGraph.Node cloned) {
            if (original == null && cloned == null) {
                return;
            }

            Set<CloneGraph.Node> originalNodes = getAllNodes(original);
            Set<CloneGraph.Node> clonedNodes = getAllNodes(cloned);

            // Verify no shared node objects
            for (CloneGraph.Node origNode : originalNodes) {
                for (CloneGraph.Node clonedNode : clonedNodes) {
                    assertThat(clonedNode).isNotSameAs(origNode);
                }
            }
        }

        private static Set<CloneGraph.Node> getAllNodes(CloneGraph.Node startNode) {
            if (startNode == null) {
                return new HashSet<>();
            }

            Set<CloneGraph.Node> allNodes = new HashSet<>();
            Queue<CloneGraph.Node> queue = new LinkedList<>();

            queue.offer(startNode);
            allNodes.add(startNode);

            while (!queue.isEmpty()) {
                CloneGraph.Node current = queue.poll();

                for (CloneGraph.Node neighbor : current.neighbors) {
                    if (!allNodes.contains(neighbor)) {
                        allNodes.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }

            return allNodes;
        }
    }
}
