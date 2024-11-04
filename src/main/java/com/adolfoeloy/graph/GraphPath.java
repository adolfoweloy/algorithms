package com.adolfoeloy.graph;

public interface GraphPath {

    boolean hasPathTo(int v);

    Iterable<Integer> pathTo(int v);

}
