package com.adolfoeloy.graph.bfs;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> visited = new HashMap<>();

        Node copy = new Node(node.val);
        queue.offer(node);
        visited.put(node, copy);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            var parentClone = visited.get(current);

            for (var neighbor : current.neighbors) {

                // if the neighbor is not visited
                if (!visited.containsKey(neighbor)) {
                    // clone the neighbor
                    var clone = new Node(neighbor.val, new ArrayList<>());
                    // visit the neighbor
                    visited.put(neighbor, clone);
                    // add the new node to the queue
                    queue.offer(neighbor);
                }

                var clonedNeighbor = visited.get(neighbor);
                parentClone.neighbors.add(clonedNeighbor);
            }

        }
        return copy;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
