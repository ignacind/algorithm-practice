package leetcode.classes;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;


    public Node() {}

    public Node(List<Node> _children) {
        this.children = _children;
    }

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val,List<Node> _children) {
        this.val = _val;
        this.children = _children;
    }

    public String toString() {
        return "Node{" +
                "val=" + val +
                ", children=" + children
                +"}";
    }
}
