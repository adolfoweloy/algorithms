package com.adolfoeloy;

import com.adolfoeloy.datastructure.ListNode;

import java.util.Stack;

/**
 * This solution is not the most efficient one since it goes through the linked list twice.
 * Beyond that, it uses a stack to reverse the linked list and creates new nodes for the reversed list.
 */
public class ReverseLinkedListOptimized {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
