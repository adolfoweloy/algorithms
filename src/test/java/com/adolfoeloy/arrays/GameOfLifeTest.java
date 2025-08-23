package com.adolfoeloy.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTest {

    private final GameOfLife gameOfLife = new GameOfLife();

    @Test
    @DisplayName("Should handle example 1 from LeetCode - 3x3 board with oscillator pattern")
    void testExample1() {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        };

        int[][] expected = {
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle example 2 from LeetCode - 2x2 board with stable block pattern")
    void testExample2() {
        int[][] board = {
                {1, 1},
                {1, 0}
        };

        int[][] expected = {
                {1, 1},
                {1, 1}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle empty board - all cells dead")
    void testEmptyBoard() {
        int[][] board = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle all cells alive - underpopulation and overpopulation")
    void testAllCellsAlive() {
        int[][] board = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle single cell alive - dies from underpopulation")
    void testSingleCellAlive() {
        int[][] board = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle block pattern - stable configuration")
    void testBlockPattern() {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int[][] expected = {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle blinker pattern - oscillates between horizontal and vertical")
    void testBlinkerPattern() {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle 1x1 board with dead cell")
    void testSingleCellDead() {
        int[][] board = {{0}};
        int[][] expected = {{0}};

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle 1x1 board with live cell")
    void testSingleCellLive() {
        int[][] board = {{1}};
        int[][] expected = {{0}};

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle rectangular board - different from square")
    void testRectangularBoard() {
        int[][] board = {
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] expected = {
                {1, 1, 0},
                {1, 0, 0}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle cells that become alive from reproduction")
    void testReproduction() {
        int[][] board = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 0}
        };

        int[][] expected = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }

    @Test
    @DisplayName("Should handle edge cases with cells on board boundaries")
    void testBoundaryConditions() {
        int[][] board = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        gameOfLife.gameOfLife(board);

        assertThat(board).isDeepEqualTo(expected);
    }
}