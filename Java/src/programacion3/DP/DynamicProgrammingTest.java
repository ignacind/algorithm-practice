package programacion3.DP;

import org.junit.jupiter.api.Test;
import tda.impl.Solicitud;

import java.util.ArrayList;

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

    @Test
    void subsecuenciaStrings() {
        String a = " dado";
        String b = " dacaodos";
        System.out.println(DynamicProgramming.subsecuenciaStrings(a, b));
    }

    @Test
    void caminos_laberinto() {
        int[][] lab = new int[][]
                {
                        {0, 0, 0, 0, 0},
                        {0, 0, -1, 0, -1},
                        {0, 0, 0, 0, 0},
                        {0, -1, 0, -1, 0},
                        {0, 0, 0, 0, 0}
                };
        int m = lab.length;
        int n = lab[0].length;

        System.out.println(DynamicProgramming.caminos_laberinto(lab, m, n));
    }

    @Test
    void repeteadElements_knapsack() {
        int[] values = new int[] {2,4,6,2};
        int[] weights = new int[] {3,3,4,2};
        int w = 8;

        System.out.println(DynamicProgramming.repeteadElements_knapsack(w, values, weights));
    }

    @Test
    void redoMinimumPath() {
        int[][] paths = new int[][] {
                {0, 11, 6, 0, 0, 0},
                {0, 0, 7, 10, 5, 0},
                {0, 0, 0, 6, 5, 0},
                {0, 0, 0, 0, 8, 15},
                {0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0}
            };
        System.out.println(DynamicProgramming.redoMinimumPath(paths));
    }

    @Test
    void goldRush() {
        int[][] g = new int[][] {
                {3, 1, 1, 1, 1},
                {2, 2, 0, 1, 3},
                {1, 1, 1, 2, 2},
                {2, 5, 5, 1, 1}
        };
        int[] path = DynamicProgramming.goldRush(g, g.length, g[0].length);
        for(int n : path) {
            System.out.print(n + " ");
        }
    }
    @Test
    void bellmanFord() {
        int[][] m = new int[][] {
                {0, 6, 5, 5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, -1, 0, 0},
                {0, -2, 0, 0, 0, 1, 0, 0},
                {0, 0, -2, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

}