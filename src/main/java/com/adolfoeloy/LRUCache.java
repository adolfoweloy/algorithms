package com.adolfoeloy;

public interface LRUCache {

    int get(int key);

    void put(int key, int value);

    int size();
}
