package hackerrank.week3;

import org.junit.Test;

public class InsertNodeInPositionOfLinkedList {

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        int index = 0;
        SinglyLinkedListNode dummy = head;

        while (head != null) {
            if (index == position-1) {
                var temp = head.next;
                head.next = new SinglyLinkedListNode(data);
                head.next.next = temp;
            }
            head = head.next;
            index++;
        }


        return dummy;
    }

    @Test
    public void sampleTest() {
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(3);
        node1.next = node2;
        node2.next = node3;

        System.out.println(insertNodeAtPosition(node1, 4, 2));

    }
}
