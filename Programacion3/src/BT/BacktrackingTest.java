package BT;

import org.junit.jupiter.api.Test;
import tda.impl.Musico;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingTest {

    @Test
    void n_Damas() {
        List<Integer> s = new ArrayList<>();
        s.add(0);
        s.add(0);
        s.add(0);
        s.add(0);
        assertTrue(BT.Backtracking.n_Damas(s, 0));
    }

    @Test
    void subset_Sums() {
        int[] v = new int[] {5, 7, 6, 10,11};
        int[] solution = new int[v.length];
        int m = 11;

        Backtracking.subset_Sums(v, m, solution, 0, 0);
    }

    @Test
    void equalSum_subSets() {
        int[] sub1 = new int[] {2,5,8,3,2};
        int[] sub2 = new int[sub1.length];
        int sum1 = Arrays.stream(sub1).sum();

        assertTrue(Backtracking.equalSum_subSets(sub1, 0, 0));
    }

    @Test
    void permutations_1234() {
        int[] nums = new int[]{1,2,3,4};
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> perms = new ArrayList<>();
        Backtracking.permutations_1234(nums, comb, perms);

        System.out.println(perms);
    }

    @Test
    void roomPath_max() {
        int[][] matrixRooms = new int[][] {
                {0,1,1,1,0,0},
                {0,0,0,0,0,1},
                {0,0,0,1,0,0},
                {0,0,0,0,1,1},
                {0,0,0,0,0,1},
                {0,0,0,0,0,0}
        };

        List<Integer> path = new ArrayList<>();
        path.add(0);
        List<Integer> longestPath = new ArrayList<>();
        Backtracking.roomPath_max(matrixRooms, matrixRooms.length, path, longestPath);

        System.out.println(longestPath);

    }

    @Test
    void permutations_Orquesta() {
        List<Musico> musicos = new ArrayList<>();
        musicos.add(new Musico("78", "vln"));
        musicos.add(new Musico("86", "vla"));
        musicos.add(new Musico("07", "vla"));
        musicos.add(new Musico("19", "vcl"));
        musicos.add(new Musico("91", "vln"));
        musicos.add(new Musico("98", "vcl"));

        List<String> perm = new ArrayList<>();
        List<List<String>> permutations = new ArrayList<>();

        Backtracking.permutations_Orquesta(musicos, perm, permutations);

        // EXPECTED = [[78, 91, 86, 19], [78, 91, 86, 98], [78, 91, 07, 19], [78, 91, 07, 98], [91, 78, 86, 19], [91, 78, 86, 98], [91, 78, 07, 19], [91, 78, 07, 98]]

        System.out.println(permutations);
    }

    @Test
    void corchosGame() {
        int e = 6;
        System.out.println(Backtracking.chorchosGame(6, 1));
    }

    @Test
    void permutations_parcial2() {
        int[] a = new int[] {1,2,3,4,5,6,7,8};
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        Backtracking.permutations_parcial2(a, perm, permutations);
        System.out.println(permutations);
    }

    @Test
    void conjunto_potencias() {
        Set<Set<Integer>> sets = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        Backtracking.conjunto_potencia(0, a, temp, sets);
        System.out.println(sets);
    }
}