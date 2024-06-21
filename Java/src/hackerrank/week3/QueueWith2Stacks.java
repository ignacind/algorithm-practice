package hackerrank.week3;

import java.util.Scanner;
import java.util.Stack;

public class QueueWith2Stacks<T> {

    public static void main(String[] args) {
        QueueWith2Stacks<Integer> queue = new QueueWith2Stacks<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of queries: ");
        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++) {
            System.out.println("Query type: ");
            int qType = scanner.nextInt();

            if (qType == 1) {
                System.out.println("Element to enqueue: ");
                int element = scanner.nextInt();
                queue.enqueue(element);
            } else if (qType == 2) {
                queue.dequeue();
            } else if (qType == 3) {
                System.out.println(queue.poll());
            }
        }
        scanner.close();

    }
    private Stack<T> enqueueStack;
    private Stack<T> dequeStack;

    public QueueWith2Stacks() {
        enqueueStack = new Stack<>();
        dequeStack = new Stack<>();
    }

    public void enqueue(T obj) {
        enqueueStack.push(obj);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException();

        if (dequeStack.isEmpty()) {
            transferObjects();
        }

        return dequeStack.pop();
    }

    private void transferObjects() {
        while(!enqueueStack.isEmpty()){
            dequeStack.push(enqueueStack.pop());
        }
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeStack.isEmpty();
    }

    public T poll() {
        if (isEmpty()) throw new RuntimeException();

        if (dequeStack.isEmpty()) {
            transferObjects();
        }

        return dequeStack.peek();
    }
}
