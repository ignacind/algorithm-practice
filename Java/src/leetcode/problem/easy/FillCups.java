package leetcode.problem.easy;

import java.util.Arrays;

public class FillCups {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int sum = amount[0] + amount[1] + amount[2];
        if (amount[0] + amount[1] > amount[2]) return sum/2+sum%2;
        else return amount[2];
    }
}
