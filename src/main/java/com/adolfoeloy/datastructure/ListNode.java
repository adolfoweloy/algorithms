package com.adolfoeloy.datastructure;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;
    ListNode(int val) { this.val = val; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode nodeValue = (ListNode) o;
        return Objects.equals(val, nodeValue.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return Objects.toString(val);
    }
}