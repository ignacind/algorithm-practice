package hackerrank.week3;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(1);
        node.next = new SinglyLinkedListNode(2);
        node.next.next = new SinglyLinkedListNode(3);
        System.out.println("BEFORE " + node);
        System.out.println("OUTPUT " + reverse(node));
        System.out.println("AFTER " + node);
    }
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        Stack<SinglyLinkedListNode> stack = new Stack<>();
        while (llist.next != null) {
            stack.push(new SinglyLinkedListNode(llist.data));
            llist = llist.next;
        }
        if (llist != null) {
            stack.push(llist);
        }
        SinglyLinkedListNode reversed = new SinglyLinkedListNode(0);
        SinglyLinkedListNode dummy = reversed;
        while (!stack.isEmpty()) {
            reversed.next = stack.pop();
            reversed = reversed.next;
        }

        return dummy.next;
    }
}




//class SinglyLinkedList {
//    public SinglyLinkedListNode head;
//    public SinglyLinkedListNode tail;
//
//    public SinglyLinkedList() {
//        this.head = null;
//        this.tail = null;
//    }
//
//    public void insertNode(int nodeData) {
//        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
//
//        if (this.head == null) {
//            this.head = node;
//        } else {
//            this.tail.next = node;
//        }
//
//        this.tail = node;
//    }
//}

