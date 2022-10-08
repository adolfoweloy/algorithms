package com.adolfoeloy.classic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArraysTest {

    private final Arrays subject = new Arrays();

    @Test
    @DisplayName("reverse words")
    void testCase1() {
        String input = "Let's take LeetCode contest";
        assertThat(subject.reverseWord(input)).isEqualTo("s'teL ekat edoCteeL tsetnoc");
    }

    @Test
    @DisplayName("reverse text with one word")
    void testCase2() {
        String input = "a";
        assertThat(subject.reverseWord(input)).isEqualTo("a");
    }
}