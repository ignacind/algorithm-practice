package DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicProgrammingTest {

    @Test
    void navegationPrice() {
        int[][] prices = {
              // 0  1  2  3  4  5  6
        /* 0 */ {0, 2, 4, 6, 0, 0, 0},
        /* 1 */ {0, 0, 1, 2, 5, 0, 0},
        /* 2 */ {0, 0, 0, 3, 0, 0, 0},
        /* 3 */ {0, 0, 0, 0, 2, 2, 0},
        /* 4 */ {0, 0, 0, 0, 0, 1, 3},
        /* 5 */ {0, 0, 0, 0, 0, 0, 5},
        /* 6 */ {0, 0, 0, 0, 0, 0, 0}
        };
        int actual = DynamicProgramming.navegationPrice(prices, prices.length, 5);
        int expected = 9;
        assertEquals(expected, actual);
    }
}