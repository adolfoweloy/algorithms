package com.adolfoeloy;

/**
 * I found this solution easier to reason about compared to the one that saves extra space used by temporary array.
 * The one that saves space was saving 1MB out of 51MB. So I don't consider using 50MB instead of 51MB a considering improving.
 *
 * The other solution which I consider to be elegant, uses a queue as a temporary data-structure to extract from one array
 * before polling values from it to create the reshaped array. However, that was slower compared to the current solution.
 *
 * I believe that extra operations in the linked list in order to update head and tail accounts for extra operations
 * compared to just writing and reading directly from the temporary array.
 */
public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int dim = mat.length * mat[0].length;
        if (dim != (r*c)) return mat;

        // creates a one dimension array
        int[] tmp = new int[dim];
        int col = 0;
        for (int[] rows : mat) {
            for (int element : rows) {
                tmp[col++] = element;
            }
        }

        // read from one dimension array
        int[][] res = new int[r][c];
        col=0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                res[i][j] = tmp[col++];
            }
        }

        return res;
    }
}
