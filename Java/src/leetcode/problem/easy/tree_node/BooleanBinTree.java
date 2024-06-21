package leetcode.problem.easy.tree_node;

import leetcode.classes.TreeNode;
import org.junit.Test;

public class BooleanBinTree {
    public boolean evaluateTree(TreeNode root) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return root.val == 2 ? left || right : left && right;
    }


    @Test
    public void sampleTest() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(evaluateTree(root));
    }
}
