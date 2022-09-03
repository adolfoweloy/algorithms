package com.adolfoeloy.datastructure;

public class DoublyLinkedList {
    private final ListNode head = new ListNode(0);
    private final ListNode tail = new ListNode(0);
    private int size = 0;

    DoublyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);

        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        ListNode node = head;
        for (int i = 0; i <= index; i++) node = node.next;

        ListNode newNode = new ListNode(val);

        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;
        node.prev = newNode;

        size++;
    }

    public int get(int index) {
        if (size == 0 || index < 0 || index >= size) return -1;
        ListNode node = head;
        for (int i = 0; i <= index; i++) node = node.next;
        return node.val;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode toDelete = head;
        for (int i = 0; i <= index; i++) toDelete = toDelete.next;

        toDelete.prev.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;

        toDelete.next = null;
        toDelete.prev = null;

        size--;
    }

    public int size() {
        return size;
    }

    public ListNode getHead() {
        return head;
    }
}
