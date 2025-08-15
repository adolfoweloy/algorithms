package com.adolfoeloy.slidingwindow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubstringNoRepetitionTest {
    private final LongestSubstringNoRepetition subject = new LongestSubstringNoRepetition();

    @Test
    void testCase1() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    void testCase2() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    void testCase3() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }

    @Test
    void testEmptyString() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("")).isEqualTo(0);
    }

    @Test
    void testSingleCharacter() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("a")).isEqualTo(1);
    }

    @Test
    void testAllSameCharacters() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    void testNoRepeatingChars() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("abcdef")).isEqualTo(6);
    }

    @Test
    void testWithSpaces() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("hello world")).isEqualTo(6);
    }

    @Test
    void testWithSpecialCharacters() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("ab@#$%^&*()cd")).isEqualTo(13);
    }

    @Test
    void testWithNumbers() {
        Assertions.assertThat(subject.lengthOfLongestSubstring("abc123def")).isEqualTo(9);
    }
}