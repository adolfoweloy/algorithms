package com.adolfoeloy;

import com.google.common.annotations.VisibleForTesting;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Node head = new Node();
    private final Node tail = new Node();

    private static class Node {
        Integer key;
        Integer value;
        Node next;
        Node prev;
        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
        Node() {}
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        return moveHead(node).value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            moveHead(node);
            node.value = value;
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addFront(newNode);
            if (cache.size() > capacity) {
                Node removed = removeTail();
                cache.remove(removed.key);
            }
        }
    }

    private Node addFront(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        return node;
    }

    private Node moveHead(Node node) {
        remove(node);
        addFront(node);
        return node;
    }

    private Node removeTail() {
        Node toRemove = tail.prev;
        remove(toRemove);
        return toRemove;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    @VisibleForTesting
    int size() {
         return cache.size();
    }
}
