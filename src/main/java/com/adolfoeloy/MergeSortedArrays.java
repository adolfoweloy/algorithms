package com.adolfoeloy;

import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] cp = Arrays.copyOf(nums1, m);
        int p1 = 0, p2 = 0;
        for (int p=0; p<(m+n); p++) {
            if (p2 >= n || (p1 < m && cp[p1] <= nums2[p2])) {
                nums1[p] = cp[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }
}
