package leetcode.problem.easy.tree_node;

import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class SumNodesInRange {

    public int rangeSumBST_V2(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(low <= root.val && high >= root.val){
            sum += root.val + rangeSumBST_V2(root.left, low, high) + rangeSumBST_V2(root.right, low, high);
        }else if(low > root.val){
            sum += rangeSumBST_V2(root.right, low, high);
        }else {
            sum += rangeSumBST_V2(root.left, low, high);
        }
        return sum;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val >= low && root.val <= high) {
            result += root.val;
        }

        result += rangeSumBST(root.left, low, high);
        result += rangeSumBST(root.right, low, high);

        return result;
    }


    public int getRangeSumWithStack(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        int result = 0;
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node == null) {
                continue;
            }
            if (node.val >= low && node.val <= high) {
                result += node.val;
            }
            stack.add(node.left);
            stack.add(node.right);
        }

        return result;
    }

    @Test
    public void sample() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        long startTime = System.nanoTime();

        System.out.println(rangeSumBST(root, 7, 15));
        System.out.println("Recursive approach " + (System.nanoTime() - startTime) + " nano");

        startTime = System.nanoTime();

        System.out.println(rangeSumBST_V2(root, 7, 15));
        System.out.println("RecursiveV2 approach " + (System.nanoTime() - startTime) + " nano");

        startTime = System.nanoTime();

        System.out.println(getRangeSumWithStack(root, 7, 15));
        System.out.println("Iterative approach " + (System.nanoTime() - startTime) + " nano");

    }



}
