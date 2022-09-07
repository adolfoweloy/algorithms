package com.adolfoeloy;

import java.util.Arrays;

public class MatrixSearch {
    // searching a value within a 2d matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix.length > 0 ? matrix[0].length : 0;
        int vs = m*n; // vector size

        int[] v = new int[vs];

        int r = 1;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int idx = i*n+j;
                v[idx] = matrix[i][j];
            }
        }

        int idx = Arrays.binarySearch(v, target);
        return (idx > -1);
    }
}
