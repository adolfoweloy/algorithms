package com.adolfoeloy.datastructure.util;

import com.adolfoeloy.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListUtil {

    public static List<Integer> toArrayList(ListNode head, int size) {
        ListNode node = head.next;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

}
