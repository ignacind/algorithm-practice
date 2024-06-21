package hackerrank.week3;

import org.junit.Test;

import java.util.*;

public class ShelockString {

    public static String isValid(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> freqCountMap = new HashMap<>();
        for (int freq : freqMap.values()) {
            freqCountMap.put(freq, freqCountMap.getOrDefault(freq, 0) + 1);
        }


        if (freqCountMap.size() == 1) {
            return "YES";
        }

        if (freqCountMap.size() == 2) {
            int minFreq = Integer.MAX_VALUE;
            int maxFreq = Integer.MIN_VALUE;
            int minFreqCount = 0;
            int maxFreqCount = 0;
            for (int freq : freqCountMap.keySet()) {
                minFreq = Math.min(minFreq, freq);
                maxFreq = Math.max(maxFreq, freq);
                if (freq == minFreq) {
                    minFreqCount = freqCountMap.get(freq);
                } else {
                    maxFreqCount = freqCountMap.get(freq);
                }
            }
            if ((minFreq == 1 && minFreqCount == 1) || (maxFreq - minFreq == 1 && maxFreqCount == 1)) {
                return "YES";
            }
        }

        return "NO";
    }


    @Test
    public void test() {
        System.out.println(isValid("abcdefghhgfedecba"));
    }
}
