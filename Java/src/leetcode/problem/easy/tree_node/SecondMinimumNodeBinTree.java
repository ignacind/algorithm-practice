package leetcode.problem.easy.tree_node;

import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.Stack;


/** Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

 Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

 If no such second minimum value exists, output -1 instead. */

public class SecondMinimumNodeBinTree {

    public int findSecondMinimumValue(TreeNode root) {
        int fstMin = Integer.MAX_VALUE;
        long scndMin = Long.MAX_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            int n = node.val;

            if (n < fstMin) {
                fstMin = n;
            } else if (n != fstMin) {
                scndMin = Math.min(scndMin, n);
            }
            stack.add(node.left);
            stack.add(node.right);
        }

        return scndMin != Long.MAX_VALUE ? (int) scndMin : -1;
    }


    @Test
    public void sampleTest() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode((Integer.MAX_VALUE));
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);

        System.out.println(findSecondMinimumValue(root));
    }
}
