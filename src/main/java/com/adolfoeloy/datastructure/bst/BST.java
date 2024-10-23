package com.adolfoeloy.datastructure.bst;

public interface BST<Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);

    int size();

    Value get(Key key);

    void delete(Key key);

    Iterable<Key> iterator();
}
