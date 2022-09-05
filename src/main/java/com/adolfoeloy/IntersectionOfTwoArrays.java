package com.adolfoeloy;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] r = new int[Integer.min(nums1.length, nums2.length)];
        Map<Integer, Integer> h = new HashMap<>();
        for (int n : nums1) {
            h.put(n, h.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for (int n : nums2) {
            int v = h.getOrDefault(n, 0);
            if (v > 0) {
                r[count++] = n;
                h.put(n, v-1);
            }
        }
        return Arrays.copyOf(r, count);
    }
}
