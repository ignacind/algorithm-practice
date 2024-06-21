package leetcode.problem.easy.tree_node;

import leetcode.classes.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderNchildren {

    public List<Integer> output_arr = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        postorderHelper(root);
        output_arr.add(root.val);
        return output_arr;
    }

    void postorderHelper(Node root) {
        if (root.children == null) {
            return;
        }
        for (Node child : root.children) {
            postorderHelper(child);
            output_arr.add(child.val);
        }

    }

    public List<Integer> postorder_Iteratively(Node root) {
        if (root==null) return output_arr;
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            if (n.children != null) {
                stack.addAll(n.children);
            }
            output_arr.add(n.val);

        }
        Collections.reverse(output_arr);
        return output_arr;
    }


    @Test
    public void sampleTest() {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        System.out.println(root);

        System.out.println(postorder_Iteratively(root));

    }
}
