package com.adolfoeloy.datastructure;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
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

        ListNode n = head;
        for (int i=0; i<index; i++) n = n.next;

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

    private ListNode getNodeBefore(int index) {
        ListNode n = head;
        for (int i = 0; i < index; i++) n = n.next;
        return n;
    }

    public List<Integer> toArrayList() {
        ListNode node = head.next;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    public int size() {
        return size;
    }
}
