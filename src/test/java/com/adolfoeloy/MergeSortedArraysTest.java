package com.adolfoeloy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortedArraysTest {
    private MergeSortedArrays subject = new MergeSortedArrays();

    @Test
    void testCase1() {
        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[] {2,5,6};
        subject.merge(a, 3, b, 3);
        assertThat(a).containsExactly(new int[] {1,2,2,3,5,6});
    }

    @Test
    void testCase2() {
        int[] a = new int[]{1};
        int[] b = new int[] {};
        subject.merge(a, 1, b, 0);
        assertThat(a).containsExactly(new int[] {1});
    }

}