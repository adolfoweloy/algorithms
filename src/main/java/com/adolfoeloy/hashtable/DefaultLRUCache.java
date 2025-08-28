package com.adolfoeloy.hashtable;

import java.util.HashMap;
import java.util.Map;

public class DefaultLRUCache implements LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList usageList;

    public DefaultLRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.usageList = new DoublyLinkedList();
    }

    @Override
    public int get(int key) {
        var element = cache.get(key);

        if (element == null) {
            return -1;
        }

        // update the usage list
        usageList.moveToFront(element);

        return element.value;
    }

    @Override
    public void put(int key, int value) {
        var element = cache.get(key);

        if (element == null) {
            var node = usageList.addFirst(key, value);
            cache.put(key, node);
            if (cache.size() > capacity) {
                var removed = usageList.removeLast();
                cache.remove(removed.key);
            }
        } else {
            usageList.moveToFront(element);
        }
    }

    @Override
    public int size() {
        return cache.size();
    }

    static class Node {
        private Node previous;
        private Node next;
        private int key;
        private int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList {
        private Node head;
        private Node tail;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.previous = head;
        }

        public void moveToFront(Node element) {
            var prev = element.previous;
            var next = element.next;

            prev.next = next;
            next.previous = prev;

            addFirst(element);
        }

        public Node addFirst(int key, int value) {
            return addFirst(new Node(key, value));
        }

        private Node addFirst(Node node) {
            // start the logic
            // node pointers
            node.next = head.next;
            node.previous = head;

            // pointing to the node
            head.next.previous = node;
            head.next = node;

            return node;
        }

        public Node removeLast() {
            if (head.next == tail.next) {
                throw new IllegalStateException("The list is empty. There is nothing to remove.");
            }

            var removed = tail.previous;
            removed.previous.next = tail;
            tail.previous = removed.previous;

            // avoid loitering
            removed.next = null;
            removed.previous = null;

            return removed;
        }

        String printList() {
            StringBuilder sb = new StringBuilder();
            Node h = head;
            sb.append("head");
            while (h != tail) {
                if (h != head) {
                    sb.append("->");
                    sb.append(h.value);
                }
                h = h.next;
            }
            sb.append("->tail");
            return sb.toString();
        }
    }
}
