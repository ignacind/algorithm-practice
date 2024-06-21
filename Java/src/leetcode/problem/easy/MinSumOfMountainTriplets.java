package leetcode.problem.easy;

import org.junit.Test;

import java.util.Collections;

public class MinSumOfMountainTriplets {
    public int minimumSum(int[] nums) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i<nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                int k = j+1;
                while (k < nums.length) {
                    if (nums[i] < nums[j] && nums[j] > nums[k]) {
                        result = Math.min(result, nums[i] + nums[j] + nums[k]);
                    }
                    k++;
                }
            }
        }
        return result==Integer.MAX_VALUE ? -1 : result;
    }


    @Test
    public void sample() {
        int[] nums = new int[]{5,4,8,7,10,2}; // Expected = 13
        System.out.println(minimumSum(nums));
    }
}
