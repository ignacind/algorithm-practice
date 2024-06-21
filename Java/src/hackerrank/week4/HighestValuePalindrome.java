package hackerrank.week4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HighestValuePalindrome {
    public static String highestValuePalindrome(String s, int n, int k) {
        int[] indexOfDiffer = new int[n];
        char[] chars = s.toCharArray();
        for (int left = 0, right = n-1; left < right; left++, right--) {
            if (chars[left] != chars[right]) {
                if (k==0) return "-1";
                else {
                    char maxNum = (char) Math.max(chars[left], chars[right]);
                    chars[left] = maxNum;
                    chars[right] = maxNum;
                    indexOfDiffer[left] = 1;
                    k--;
                }
            }
        }
        if (k == 0) return new String(chars);

        for (int left = 0, right = n-1; left <= right; left++, right--) {
            if (k > 0 && chars[left] != '9') {
                if (indexOfDiffer[left] == 1 || left == right) {
                    chars[left] = '9'; chars[right] = '9';
                    k--;
                } else if (k >= 2) {
                    chars[left] = '9'; chars[right] = '9';
                    k-=2;
                }
            }
        }
        return new String(chars);
    }

    @Test
    public void sampleTest() {
        String s = "092282";
        System.out.println(highestValuePalindrome(s, s.length(), 3));
    }
}
