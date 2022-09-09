package com.adolfoeloy;

import com.adolfoeloy.datastructure.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CycleDetectionTest {
    private final CycleDetection subject = new CycleDetection();

    @Test
    void testCase1() {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        Assertions.assertThat(subject.hasCycle(a)).isTrue();
    }

    @Test
    void testCase2() {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        a.next = b;
        b.next = a;

        Assertions.assertThat(subject.hasCycle(a)).isTrue();
    }

    @Test
    void testCase3() {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        a.next = b;

        Assertions.assertThat(subject.hasCycle(a)).isFalse();
    }

    @Test
    void testCase4() {
        ListNode a = new ListNode(0);

        Assertions.assertThat(subject.hasCycle(a)).isFalse();
    }

    @Test
    void testCase5() {
        ListNode a = new ListNode(0);
        a.next = a;
        Assertions.assertThat(subject.hasCycle(a)).isTrue();
    }
}