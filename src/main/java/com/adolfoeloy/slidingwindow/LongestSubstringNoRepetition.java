package com.adolfoeloy.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepetition {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            hash.put(r, hash.getOrDefault(r, 0) + 1);
            while (hash.get(r) > 1) {
                char l = s.charAt(left);
                hash.put(l, hash.get(l) - 1);
                left++;
            }
            max = Integer.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
