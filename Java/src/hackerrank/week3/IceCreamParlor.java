package hackerrank.week3;

import org.junit.Test;

import java.util.*;

public class IceCreamParlor {
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        Map<Integer, Integer> differenceMap = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            if (differenceMap.containsKey(arr.get(i))) {
                return new ArrayList<>(Arrays.asList(differenceMap.get(arr.get(i)), i+1));
            }
            differenceMap.put(m-arr.get(i), i+1);
        }

        return null;
    }

    @Test
    public void sampleTest() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1); arr.add(3); arr.add(4); arr.add(5); arr.add(6);
        int m = 6;

        System.out.println(icecreamParlor(6, arr));
    }
}
