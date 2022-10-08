package com.adolfoeloy.classic;

public class Arrays {
    public String reverseWord(String s) {
        String[] words = s.split("\s");
        String reduce = java.util.Arrays.stream(words)
                .map(word -> reverse(word))
                .reduce("", (a, b) -> a + " " + b);
        return reduce.trim();
    }

    private String reverse(String word) {
        char[] cword = word.toCharArray();
        for (int i=0, j=cword.length - 1; i < j; i++, j--) {
            char tmp = cword[i];
            cword[i] = cword[j];
            cword[j] = tmp;
        }
        return new String(cword);
    }
}
