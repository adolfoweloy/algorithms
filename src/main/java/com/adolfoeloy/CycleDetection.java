package com.adolfoeloy;

import com.adolfoeloy.datastructure.ListNode;

/**
 * This is an implementation of Floyd's turtle and hare cycle detection algorithm.
 * To detect the cycle, the algorithm uses two pointers: one fast and one slow.
 * By moving two pointer at different pace they eventually meet each other again when a cycle exists.
 * Otherwise, if they don't meet each other and the faster reaches the end of the path, there's no cycle.
 */
public class CycleDetection {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
