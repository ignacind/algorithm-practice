package hackerrank.week3;

import java.util.Scanner;

public class MergeTwoLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        SinglyLinkedListNode dummyA = new SinglyLinkedListNode(0);
        var headA = getHead(dummyA, scanner);

        SinglyLinkedListNode dummyB = new SinglyLinkedListNode(0);
        var headB = getHead(dummyB, scanner);

        SinglyLinkedListNode merged = mergeLinkedList(headA.next, headB.next);
        System.out.println(merged);
    }

    private static SinglyLinkedListNode getHead(SinglyLinkedListNode head, Scanner scanner) {
        int length = scanner.nextInt();
        var dummy = head;
        for (int i = 0; i<length; i++) {
            head.next = new SinglyLinkedListNode(scanner.nextInt());
            head = head.next;
        }
        return dummy;
    }

    private static SinglyLinkedListNode mergeLinkedList(SinglyLinkedListNode A, SinglyLinkedListNode B) {
        SinglyLinkedListNode merged = new SinglyLinkedListNode(0);
        var dummy = merged;

        while (A != null && B != null) {
            if (A.data < B.data) {
                merged.next = new SinglyLinkedListNode(A.data);
                A = A.next;
            } else {
                merged.next = new SinglyLinkedListNode(B.data);
                B = B.next;
            }
            merged = merged.next;
        }
        getRemaining(A, merged);
        getRemaining(B, merged);
        return dummy.next;
    }

    private static void getRemaining(SinglyLinkedListNode head, SinglyLinkedListNode merged) {
        while (head!=null) {
            merged.next = new SinglyLinkedListNode(head.data);
            head = head.next;
            merged = merged.next;
        }
    }
}
