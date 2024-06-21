package leetcode.problem.medium;

import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.Stack;


/** Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

 Note:

 The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
 A subtree of root is a tree consisting of root and all of its descendants. */

public class CountNodesAvgEqualSubtree {

    public int countNodes = 0;
    public int sumOfNodes = 0;


    public int averageOfSubtree(TreeNode root) {
        int countAvg = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            countNodes = 0;
            sumOfNodes = 0;
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (isAvg(node, node.val)) {
                countAvg++;
            }
            stack.add(node.left);
            stack.add(node.right);
        }
        return countAvg;
    }


    private boolean isAvg(TreeNode node, int ogVal) {
        if (node == null) return sumOfNodes/countNodes==ogVal;

        countNodes++;
        sumOfNodes+=node.val;
        isAvg(node.left, ogVal);
        isAvg(node.right, ogVal);
        return sumOfNodes/countNodes==ogVal;
    }

    public int countOfAvg = 0;
    public int averageOfSubtreeV2(TreeNode root) {
        getAvgHelper(root);
        return countOfAvg;
    }

    private int[] getAvgHelper(TreeNode root) {
        if (root==null) return new int[2];

        int[] left = getAvgHelper(root.left);
        int[] right = getAvgHelper(root.right);

        int sumOfNodes = left[0] + right[0] + root.val;
        int amountNodes = left[1] + right[1] + 1;
        countOfAvg += sumOfNodes/amountNodes==root.val ? 1 : 0;
        return new int[]{sumOfNodes, amountNodes};
    }


    @Test
    public void sampleTest() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        averageOfSubtreeV2(root);
        System.out.println(countOfAvg);
    }
}
