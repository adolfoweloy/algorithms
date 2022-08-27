package com.adolfoeloy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntersectionOfTwoArraysTest {

    private IntersectionOfTwoArrays subject = new IntersectionOfTwoArrays();

    @Test
    void testCase1() {
        assertThat(subject.intersect(new int[] {1, 2, 3}, new int[] {2, 4, 5}))
                .containsExactlyInAnyOrder(2);
    }

    @Test
    void testCase2() {
        assertThat(subject.intersect(new int[] {1}, new int[] {2}))
                .containsExactlyInAnyOrder();
    }

    @Test
    void testCase3() {
        assertThat(subject.intersect(new int[] {1,2,2,1}, new int[] {2,2}))
                .containsExactlyInAnyOrder(2,2);
    }

    @Test
    void testCase4() {
        assertThat(subject.intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4}))
                .containsExactly(4,9);
    }
}
