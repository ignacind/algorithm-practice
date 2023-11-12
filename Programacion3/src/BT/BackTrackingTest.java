package BT;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BackTrackingTest {

    @Test
    void subset_Sums() {
        int[] v = new int[] {5, 7, 6, 10,11};
        int[] solution = new int[v.length];
        int m = 11;

        BackTracking.subset_Sums(v, m, solution, 0, 0);
    }

    @Test
    void equalSum_subSets() {
        int[] sub1 = new int[] {2,5,8,3,2};
        int[] sub2 = new int[sub1.length];
        int sum1 = Arrays.stream(sub1).sum();

        assertTrue(BackTracking.equalSum_subSets(sub1, 0, 0));
    }

    @Test
    void permutations_1234() {
        int[] nums = new int[]{1,2,3,4};
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> perms = new ArrayList<>();
        BackTracking.permutations_1234(nums, comb, 0, perms);

        for (int i = 0; i < perms.size(); i++) {
            for (int j = 0; j < perms.get(0).size(); j++) {
                System.out.println(perms.get(i).get(j));
            }

        }
    }
}