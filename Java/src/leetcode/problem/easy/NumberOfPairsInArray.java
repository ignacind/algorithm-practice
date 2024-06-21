package leetcode.problem.easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> pairsMap = new HashMap<>();
        for (int n : nums) {
            pairsMap.put(n, pairsMap.getOrDefault(n, 0) + 1);
        }
        int[] result = new int[2];
        for (int val : pairsMap.values()) {
            result[0] += val/2;
            result[1] += val%2;
        }
        return result;
    }
}
