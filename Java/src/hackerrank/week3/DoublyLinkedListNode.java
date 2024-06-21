package hackerrank.week3;

public class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }

    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next  +
                ", prev=" + ((prev != null) ? prev.data : "null") +
                "}";
    }
}