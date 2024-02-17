package com.adolfoeloy.classic;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private final List<String> result = new ArrayList<>();

    public List<String> permut(String s) {
        backtrack(s.toCharArray(), 0);
        return result;
    }

    private void backtrack(char[] a, int first) {
        if (first == a.length) {
            String p = new String(a);
            result.add(p);
        }

        for (int i=first; i<a.length; i++) {
            swap(a, i, first);
            backtrack(a, first + 1);
            swap(a, i, first);
        }
    }

    private void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
