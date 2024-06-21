package leetcode.problem.easy.tree_node;

import leetcode.classes.TreeNode;
import org.junit.Test;

public class RootEqualsSumOfChildren {
    public boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        System.out.println(checkTree(root));
    }
}
