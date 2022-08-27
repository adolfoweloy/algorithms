package com.adolfoeloy;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for (int n:nums1) {
            hash.put(n, hash.getOrDefault(n, 0) + 1);
        }
        int k=0;
        for (int n:nums2) {
            int v = hash.getOrDefault(n, 0);
            if (v > 0) {
                nums1[k++] = n;
                hash.put(n, v-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
