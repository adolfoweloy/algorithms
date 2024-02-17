package com.adolfoeloy.classic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PermutationTest {

    private Permutation subject = new Permutation();

    @Test
    void testCase() {
        Assertions.assertThat(subject.permut("a")).containsExactly("a");
    }

    @Test
    void testCase1() {
        Assertions.assertThat(subject.permut("ab")).containsExactly(
          "ab", "ba"
        );
    }

    @Test
    void testCase2() {
        Assertions.assertThat(subject.permut("abc")).contains(
                "abc", "bac", "cba", "acb", "bca", "cab"
        );
    }
}