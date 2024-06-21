package hackerrank.Test_Week2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BetweenTwoSets {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int max_fromA = Collections.max(a);
        int min_fromB = Collections.min(b);
        int count = 0;
        for (int x = Math.min(min_fromB, max_fromA); x <= Math.max(min_fromB, max_fromA); x++) {
            if (checksConditionAllFactorsOfX(x, a) && checksConditionXisFactorOfAll(x, b)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checksConditionXisFactorOfAll(int x, List<Integer> b) {
        for (int n : b) {
            if (n % x != 0) return false;
        }
        return true;
    }

    private static boolean checksConditionAllFactorsOfX(int x, List<Integer> a) {
        for (int n : a) {
            if (x % n != 0) return false;
        }
        return true;
    }
}
