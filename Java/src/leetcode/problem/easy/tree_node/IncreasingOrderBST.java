package leetcode.problem.easy.tree_node;

import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreasingOrderBST {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        getTreeValues(root, values);
        Collections.sort(values);

        return fillTree(values, 0);
    }

    public TreeNode fillTree(List<Integer> values, int index) {
        if (index >= values.size()) {
            return null;
        }
        TreeNode root = new TreeNode(values.get(index));
        root.left = null;
        root.right = fillTree(values, index +1);

        return root;

    }

    public void getTreeValues(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        getTreeValues(root.left, values);
        getTreeValues(root.right, values);
    }

    
    private TreeNode prev = null;
    public TreeNode increasingBST_DFS(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        prev = dummy;
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            node.left = null;
            prev.right = node;
            prev = node;
            inorder(node.right);
        }
    }


    @Test
    public void sampleTest() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);

        System.out.println(increasingBST_DFS(root));
    }
}
