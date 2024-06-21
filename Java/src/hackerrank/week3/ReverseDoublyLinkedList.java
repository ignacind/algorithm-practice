package hackerrank.week3;

import org.junit.Test;

import java.util.Stack;

public class ReverseDoublyLinkedList {

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        Stack<DoublyLinkedListNode> stack = new Stack<>();
        while (head != null) {
            DoublyLinkedListNode temp = head.prev;
            head.prev = head.next;
            head.next = temp;
            stack.push(head);
            head = head.prev;
        }
        DoublyLinkedListNode reversed = new DoublyLinkedListNode(0);
        var dummy = reversed;
        while (!stack.isEmpty()) {
            reversed.next = stack.pop();
            reversed = reversed.next;
        }

        return dummy.next;
    }

    @Test
    public void sampleTest() {
        DoublyLinkedListNode node1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(4);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;

        System.out.println(reverse(node1));
    }
}
