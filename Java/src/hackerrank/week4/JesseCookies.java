package hackerrank.week4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class JesseCookies {

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(A);
        while (heap.size() > 1 && heap.peek() < k) {
            heap.add(heap.poll() + heap.poll() * 2);
        }

        return heap.peek() >= k? A.size() - heap.size() : -1;
    }


    @Test
    public void sampleTest() {
        List<Integer> A = List.of(2, 7, 3, 6, 4, 6);
        System.out.println(cookies(9, A));
    }
}
