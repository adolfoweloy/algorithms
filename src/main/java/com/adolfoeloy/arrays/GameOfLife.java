package com.adolfoeloy.arrays;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        // first pass
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (willBeLive(board, i, j)) {
                    board[i][j] += 2;
                }
            }
        }

        // second pass
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                switch (board[i][j]) {
                    case 0:
                        board[i][j] = 0;  // dead stays dead
                        break;
                    case 1:
                        board[i][j] = 0;  // alive dies
                        break;
                    case 2:
                        board[i][j] = 1;  // dead becomes alive
                        break;
                    case 3:
                        board[i][j] = 1;  // alive stays alive
                        break;
                    default:
                }
            }
        }
    }

    private boolean willBeLive(int[][] board, int i, int j) {
        var count = 0;
        count += isAlive(board, i + 1, j) ? 1 : 0;
        count += isAlive(board, i + 1, j + 1) ? 1 : 0;
        count += isAlive(board, i, j + 1) ? 1 : 0;
        count += isAlive(board, i - 1, j + 1) ? 1 : 0;
        count += isAlive(board, i - 1, j) ? 1 : 0;
        count += isAlive(board, i - 1, j - 1) ? 1 : 0;
        count += isAlive(board, i, j - 1) ? 1 : 0;
        count += isAlive(board, i + 1, j - 1) ? 1 : 0;

        boolean currentlyAlive = isAlive(board, i, j);

        if (currentlyAlive) {
            // Live cell survives only with 2 or 3 neighbors
            return count == 2 || count == 3;
        } else {
            // Dead cell becomes alive only with exactly 3 neighbors
            return count == 3;
        }
    }

    private boolean isAlive(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        return (board[i][j] % 2 == 1);
    }

}
