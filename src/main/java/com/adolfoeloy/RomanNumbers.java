package com.adolfoeloy;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static Map<Character, Integer> letters = new HashMap<>();

    static {
        letters.put('I', 1);
        letters.put('V', 5);
        letters.put('X', 10);
        letters.put('L', 50);
        letters.put('C', 100);
        letters.put('D', 500);
        letters.put('M', 1000);
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {

            int max = 0;
            for (int i=0; i<values.length; i++){
                if (values[i] > num) continue;
                max = values[i];
                sb.append(symbols[i]);
                num = num - max;
                break;
            }

        }

        return sb.toString();
    }

    public int romanToInt(String roman) {
        char[] letter = roman.toCharArray();
        int total = 0;
        for (int i=0; i<letter.length; i++) {
            int n1 = letters.get(roman.charAt(i));
            total += n1;
            if (i>0) {
                int n0 = letters.get(roman.charAt(i-1));
                if (n0 < n1) {
                    total -= 2 * n0;
                }
            }
        }
        return total;
    }
}
