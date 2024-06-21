package hackerrank.week3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumBribes {

    public static void minimumBribes(List<Integer> q) {
        int count = 0;
        boolean tooChaotic = false;

        for (int i = 0; i < q.size(); i++) {
            int curr = q.get(i);

            if (curr - (i+1) > 2) {
                tooChaotic = true;
                break;
            }

            for (int j = Math.max(0, curr-2); j < i ; j++) {
                if (q.get(j) > curr) {
                    count++;
                }
            }
        }
        if (tooChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(count);
        }
    }

    @Test
    public void test() {
        int[] arr = new int[] {1, 2, 5, 3, 7, 8, 6, 4};
        List<Integer> q = Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new));
        minimumBribes(q);
    }
}
