package leetcode.problem.easy;

import org.junit.Test;

public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = (left+right) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    @Test
    public void sample() {
        System.out.println(isPerfectSquare(2147483647));
    }
}
