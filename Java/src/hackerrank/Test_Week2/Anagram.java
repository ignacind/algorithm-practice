package hackerrank.Test_Week2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagram {

    public static int anagram(String s) {
        int n = s.length();
        if (n % 2 != 0) return -1;

        HashMap<Character, Integer> counter = new HashMap<>();


        for (int i = 0; i < n / 2; i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (int i = n / 2; i < n; i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) - 1);
        }

        int sum = 0;

        for (int count : counter.values()) {
            if (count < 0) {
                sum += Math.abs(count);
            }
        }

        return sum;
    }

    @Test
    public void sample() {
        System.out.println(anagram("abccde"));
    }
}
