package com.adolfoeloy;

import com.adolfoeloy.datastructure.ListNode;

import java.util.Stack;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode n = head;
        while (n != null) {
            stack.push(n.val);
            n = n.next;
        }
        ListNode tail = null;
        ListNode first = null;
        while (!stack.empty()) {
            ListNode p = new ListNode(stack.pop());
            if (tail == null) {
                first = p;
                tail = p;
            } else {
                tail.next = p;
                tail = p;
            }
        }
        return first;
    }

}
