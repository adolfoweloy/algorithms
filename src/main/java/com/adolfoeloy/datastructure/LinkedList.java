package com.adolfoeloy.datastructure;

public class LinkedList {
    private final ListNode head = new ListNode(0);
    private int size = 0;

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        ListNode lastNode = head;
        for (int i = 0; i <size; i++) lastNode = lastNode.next;
        lastNode.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        ListNode n = getNodeBefore(index);
        ListNode newNode = new ListNode(val);
        newNode.next = n.next;
        n.next = newNode;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode prev = getNodeBefore(index);
        return prev.next.val;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode node = getNodeBefore(index);
        node.next = node.next.next;
        size--;
    }

    public ListNode deleteWhenValueIs(int val) {
        ListNode h = new ListNode(-1);
        ListNode node = head;
        h.next = node;
        ListNode prev = h;

        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
                size--;
            } else {
                prev = prev.next;
            }
            node = node.next;
        }

        return head;
    }

    private ListNode getNodeBefore(int index) {
        ListNode n = head;
        for (int i = 0; i < index; i++) n = n.next;
        return n;
    }

    public int size() {
        return size;
    }

    public ListNode getHead() {
        return head;
    }
}
