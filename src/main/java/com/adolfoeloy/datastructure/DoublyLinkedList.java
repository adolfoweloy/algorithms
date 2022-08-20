package com.adolfoeloy.datastructure;

import java.util.Objects;

public class DoublyLinkedList {

    public static class NodeValue {
        Integer value;
        NodeValue next;
        NodeValue prev;

        public NodeValue(Integer value) {
            this.value = value;
        }

        NodeValue() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeValue nodeValue = (NodeValue) o;
            return Objects.equals(value, nodeValue.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return Objects.toString(value);
        }
    }

    private NodeValue head = new NodeValue();
    private NodeValue tail = new NodeValue();

    private int size;

    public DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public NodeValue addFront(int value) {
        NodeValue node = new NodeValue(value);

        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;

        size++;
        return node;
    }

    public void moveHead(NodeValue node) {
        remove(node);
        addFront(node.value);
    }

    public void remove(NodeValue node) {
        if (size == 0) throw new IllegalStateException("Empty list");

        NodeValue next = node.next;
        NodeValue prev = node.prev;

        next.prev = prev;
        prev.next = next;

        size--;
    }

    public NodeValue removeTail() {
        NodeValue toRemove = tail.prev;
        remove(toRemove);
        return toRemove;
    }

    public int size() {
        return size;
    }
}
