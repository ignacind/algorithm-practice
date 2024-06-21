package leetcode.classes;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int _val) {
        this.val = _val;
    }
    public ListNode(int _val, ListNode _next) {
        this.val = _val;
        this.next = _next;
    }

    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                "}";
    }
}
