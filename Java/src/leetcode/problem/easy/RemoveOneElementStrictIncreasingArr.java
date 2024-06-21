package leetcode.problem.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveOneElementStrictIncreasingArr {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                count++;
                if (i > 1 && nums[i - 2] >= nums[i]) {
                    nums[i] = nums[i - 1];
                }
            }
        }

        return count < 2;
    }

    @Test
    public void sample() {
        int[] nums = new int[]{105,924,32,968};
        System.out.println(canBeIncreasing(nums));
    }
}
