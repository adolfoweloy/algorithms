package com.adolfoeloy.hashtable;

import java.util.*;

public class BuiltInLRUCache implements LRUCache{
    private final LinkedHashMap<Integer, Integer> cache;

    public BuiltInLRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    @Override
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    @Override
    public void put(int key, int value) {
        cache.put(key, value);
    }

    @Override
    public int size() {
        return cache.size();
    }
}
