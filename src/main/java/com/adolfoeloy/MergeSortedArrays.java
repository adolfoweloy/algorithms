package com.adolfoeloy;

import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] a, int n, int[] b, int m) {
        int j = 0;
        for (int i=n; i < a.length; i++) {
            a[i] = b[j];
            j = j + 1;
        }
        Arrays.sort(a);
    }
}
