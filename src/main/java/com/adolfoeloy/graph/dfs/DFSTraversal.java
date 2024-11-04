package com.adolfoeloy.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a more generic and simpler to grasp way to traverse a graph (in this case a tree).
 */
public class DFSTraversal {

    List<Node> root = new ArrayList<>();



    private static class Node {
        Node left;
        Node right;
        int value;
    }

}
