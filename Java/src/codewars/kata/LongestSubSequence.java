package codewars.kata;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubSequence {

    public static String lcs(String a, String b) {
        String[][] dp = new String[a.length()+1][b.length()+1];
        a = " " + a;
        b = " " + b;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = "";
                } else if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + a.charAt(i);
                } else {
                    dp[i][j] = !dp[i-1][j].isEmpty() && dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }
            }

        }

        return dp[a.length()-1][b.length()-1];
    }

    @Test
    public void testSample() {
        assertEquals("", lcs("", ""));
        assertEquals("", lcs("abc", ""));
        assertEquals("", lcs("", "abc"));
        assertEquals("", lcs("a", "b"));
        assertEquals("a", lcs("a", "a"));
        assertEquals("ac",lcs("abc", "ac"));
        assertEquals("abc", lcs("abcdef", "abc"));
        assertEquals("acf", lcs("abcdef", "acf"));
        assertEquals("nottest", lcs("anothertest", "notatest"));
        assertEquals("12356", lcs("132535365", "123456789"));
        assertEquals("final", lcs("nothardlythefinaltest", "zzzfinallyzzz"));
        assertEquals("acdefghijklmnoq", lcs("abcdefghijklmnopq", "apcdefghijklmnobq"));

    }
}
