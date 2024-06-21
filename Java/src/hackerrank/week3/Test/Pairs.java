package hackerrank.week3.Test;

import org.junit.Test;

import java.util.*;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> differenceSet = new HashSet<>();
        int count = 0;

        for (int n : arr) {
            differenceSet.add(n-k);
        }

        for (int n : arr){
            if (differenceSet.contains(n)) count++;
        }
        return count;
    }

    @Test
    public void sampleTest() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 5, 3, 4, 2));
        System.out.println(pairs(2, arr));
    }

}
