package com.adolfoeloy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> T = new ArrayList<>();
        T.add(Collections.singletonList(1));
        for (int row=1; row<numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            int cols = row+1;
            rowList.add(1);
            for (int col=1; col<cols-1; col++) {
                List<Integer> previousRow = T.get(row-1);
                rowList.add(col, previousRow.get(col-1) + previousRow.get(col));
            }
            rowList.add(1);
            T.add(rowList);
        }
        return T;
    }


}
