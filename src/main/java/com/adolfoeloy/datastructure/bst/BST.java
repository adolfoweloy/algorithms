package com.adolfoeloy.datastructure.bst;

public interface BST<Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);

    int size();

    /**
     * How many keys are lesser than key
     */
    int rank(Key key);

    Value get(Key key);

    void delete(Key key);

    void deleteMin();

    Iterable<Key> iterator();
}
