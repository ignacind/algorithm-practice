package leetcode.problem.easy.tree_node;


import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**Given the root of a binary tree, invert the tree, and return its root.*/
public class InvertBinTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree_Iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node == null) {
                continue;
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            stack.add(node.left);
            stack.add(node.right);
        }

        return root;
    }


    @Test
    public void sampleTest() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(invertTree_Iterative(root));
    }
}
