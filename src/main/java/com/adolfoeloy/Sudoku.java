package com.adolfoeloy;

import java.util.*;

public class Sudoku {
    public boolean isValidSudoku(char[][] m) {
        int N = 9;

        // initialise the datastructures
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r=0; r<N; r++) {
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }

        // starts the logic using the hashsets to check for duplicates in rows, cols and boxes
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                char v = m[r][c];
                if (v == '.') continue;

                // check the row
                if (rows[r].contains(v)) return false;
                rows[r].add(v);

                // check the col
                if (cols[r].contains(v)) return false;
                cols[r].add(v);

                // check the box
                int idx = (r/3) * 3 + (c/3);
                if (boxes[idx].contains(v)) return false;
                boxes[idx].add(v);
            }
        }

        return true;
    }
}
