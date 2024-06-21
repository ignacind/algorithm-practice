package hackerrank.week3;

public class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }

    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                "}";
    }
}