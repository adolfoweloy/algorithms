package com.adolfoeloy.slidingwindow;

import java.util.HashSet;

public class LongestSubstringNoRepetition {
    public int lengthOfLongestSubstring(String s) {
        var hash = new HashSet<Character>();
        var n = s.length();
        var maxLength = 0;
        var left = 0;
        var right = 0;

        while (right < n) {
            while (left < right && hash.contains(s.charAt(right))) {
                hash.remove(s.charAt(left));
                left++;
            }

            hash.add(s.charAt(right));
            right++;

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
