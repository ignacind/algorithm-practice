package hackerrank.week3.Test;

import org.junit.Test;

import java.util.*;

public class BigSorting {
    public static List<String> bigSorting(List<String> unsorted) {

        Comparator<String> comparator = (a, b) -> {
            int compareSize = Integer.compare(a.length(), b.length());

            if (compareSize == 1 || compareSize == -1) return compareSize;

            int fstDigit = Character.compare(a.charAt(0), b.charAt(0));

            if (fstDigit == 1 || fstDigit == -1) return fstDigit;

            return a.compareTo(b);

        };
        unsorted.sort(comparator);
        return unsorted;
    }

    @Test
    public void sampleTest() {
        List<String> unsorted = new ArrayList<>(Arrays.asList("2996161187512687144484781037771958873205700540555555555555", "1", "3", "29961611875126871444847810377719588732057005401"));
        System.out.println(bigSorting(unsorted));
    }
}
