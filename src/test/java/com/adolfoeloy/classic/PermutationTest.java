package com.adolfoeloy.classic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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


    @Test
    void testArrayList() {
        int[] nums = {1, 2, 3};
        var result = IntStream.of(nums).boxed().toList();
        Assertions.assertThat(result).containsExactly(1, 2, 3);
    }
}