package hackerrank.Test_Week2;

import org.junit.Test;

import java.lang.annotation.Target;

public class PalindromeIndex {

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left+1, right)){
                    return left;
                } else if (isPalindrome(s, left, right-1)) {
                    return right;
                } else {
                    return -1;
                }
            }
            left++;
            right--;
        }

        return -1;
    }

    public static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void sampleTest() {
        String s = "aaa";

        System.out.println(palindromeIndex(s));
    }
}
