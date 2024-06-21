package leetcode.problem.easy.tree_node;

import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class ReturnTreeFromBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBST_stack(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }

            if (node.val == val) {
                return node;
            }
            stack.add(node.left);
            stack.add(node.right);

        }
        return null;
    }


    @Test
    public void testSimple() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);


        System.out.println(searchBST(root, 2));
    }

    @Test
    public void testThatFail() {
        TreeNode root = new TreeNode(18);
        root.left = new TreeNode(2);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(63);
        root.right.right.right = new TreeNode(84);

        System.out.println(searchBST(root, 63));
    }
}
