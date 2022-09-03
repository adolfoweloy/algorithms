package com.adolfoeloy;

import com.adolfoeloy.datastructure.LinkedList;
import com.adolfoeloy.datastructure.ListNode;
import com.adolfoeloy.datastructure.util.LinkedListUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {

    private ReverseLinkedList subject = new ReverseLinkedList();

    @Test
    void testCase1() {
        LinkedList list = new LinkedList();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(3);

        ListNode r = subject.reverseList(list.getHead().next);

        Assertions.assertThat(LinkedListUtil.toArrayList(r, 3)).containsExactly(3, 2, 1);
    }

}