package com.adolfoeloy.classic;

public class BinarySearch {
    int find(int[] a, int n) {
        return _find(a, 0, a.length-1, n);
    }

    int _find(int[] a, int low, int high, int n) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;

        if (a[mid] < n) return _find(a, mid+1, high, n);
        if (a[mid] > n) return _find(a, low, mid-1, n);

        return mid;
    }
}
