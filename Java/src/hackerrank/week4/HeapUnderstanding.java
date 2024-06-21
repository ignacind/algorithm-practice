package hackerrank.week4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapUnderstanding {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        Scanner scanner = new Scanner(System.in);
        int numOfQueries = scanner.nextInt(); scanner.nextLine();

        for (int i = 0; i < numOfQueries; i++) {
            String query = scanner.nextLine();
            int operation = Integer.parseInt(query.split(" ")[0]);
            if (operation <= 2) {
                int number = Integer.parseInt(query.split(" ")[1]);
                if (operation == 1) {
                    heap.add(number);
                } else {
                    heap.remove(number);
                }
            } else {
                System.out.println(heap.peek());
            }
        }
        scanner.close();
    }


}
