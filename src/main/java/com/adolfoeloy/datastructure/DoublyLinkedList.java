package com.adolfoeloy.datastructure;

public class DoublyLinkedList {
    private final ListNode head = new ListNode(0);
    private final ListNode tail = new ListNode(0);

    private int size;

    public DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public ListNode addFront(int value) {
        ListNode node = new ListNode(value);

        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;

        size++;
        return node;
    }

    public void remove(ListNode node) {
        if (size == 0) throw new IllegalStateException("Empty list");

        ListNode next = node.next;
        ListNode prev = node.prev;

        next.prev = prev;
        prev.next = next;

        size--;
    }

    public int size() {
        return size;
    }
}
