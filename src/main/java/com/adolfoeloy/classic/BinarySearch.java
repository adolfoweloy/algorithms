package com.adolfoeloy.classic;

public class BinarySearch {
    int find(int[] a, int n) {
        var lo = 0;
        var hi = a.length - 1;
        while (lo <= hi) {
            var mid = lo + (hi - lo) / 2;
            if (n < a[mid]) hi = mid - 1;
            else if (n > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
