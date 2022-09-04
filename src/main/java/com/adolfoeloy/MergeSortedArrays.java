package com.adolfoeloy;

import java.util.Arrays;

/**
 * Using three pointers (two for reads and one for writes).
 * The read pointers are sentinels to navigate through a copy of nums1 and nums2.
 * The writer pointer is used to write to nums1.
 *
 * Personal note: Having to check the boundaries is the tricky part here, and it shows how
 * hard typical imperative programming is when dealing with so many variables to control the execution flow
 * in addition invariants to check.
 */
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] cp = Arrays.copyOf(nums1, (m+n));
        int r1=0, r2=0;
        for (int w = 0; w < (m+n); w++) {
            // if the read pointer for nums2 is over its size the else can't be executed
            // in order to read cp[r1], r1 must be within the boundaries of nums1
            if (r2 >= n || (r1 < m && cp[r1] <= nums2[r2])) {
                nums1[w] = cp[r1++];
            } else {
                nums1[w] = nums2[r2++];
            }
        }
    }
}
