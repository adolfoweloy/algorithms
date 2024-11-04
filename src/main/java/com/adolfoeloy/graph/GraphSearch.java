package com.adolfoeloy.graph;

public interface GraphSearch {

    /**
     * This method returns true if v is connected to the source vertex s.
     */
    boolean isMarked(int v);

    /**
     * Count the number of vertices connected to the source vertex s.
     */
    int count();

}
