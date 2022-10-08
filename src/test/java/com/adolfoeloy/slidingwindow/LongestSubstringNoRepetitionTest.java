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


}