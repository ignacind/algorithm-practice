package leetcode.problem.easy.tree_node;

import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }


    public TreeNode mergeTrees_BFS(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // If one of the nodes is null, return the other node
            if (node1 == null || node2 == null) {
                continue;
            }

            // Merge the values
            node1.val += node2.val;

            // Enqueue left children
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                queue.add(node1.left);
                queue.add(node2.left);
            }

            // Enqueue right children
            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                queue.add(node1.right);
                queue.add(node2.right);
            }
        }

        return root1;
    }

    @Test
    public void test() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        System.out.println(mergeTrees_BFS(root1, root2));
    }
}
