package leetcode.problem.easy.tree_node;

import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.*;

public class FindNode {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> orderQueue = new ArrayList<>();
        q.add(cloned);
        long startTimeQ = System.nanoTime();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            orderQueue.add(node.val);
//            if (node.val == target.val) {
//                return node;
//            }

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }
        }
        long endTimeQ = System.nanoTime() - startTimeQ;

        List<Integer> orderStack = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(original);

        long startTimeStack = System.nanoTime();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            orderStack.add(node.val);

//            if (node.val == target.val) {
//                return node;
//            }

            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }
        long endTimeStack = System.nanoTime() - startTimeStack;

        System.out.println("QUEUE: " + orderQueue + " TIME: " + endTimeQ + " nano");
        System.out.println("STACK: " + orderStack + " TIME: " + endTimeStack + " nano");
        return null;
    }

    public final TreeNode getTargetCopyDFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target)
            return cloned;
        TreeNode res = getTargetCopyDFS(original.left, cloned.left, target);
        if (res != null)
            return res;
        return getTargetCopyDFS(original.right, cloned.right, target);
    }

    @Test
    public void testSample() {
        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);

        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);

        TreeNode target = new TreeNode(3);
        target.left = new TreeNode(6);
        target.right = new TreeNode(19);

        System.out.println(getTargetCopyDFS(original, cloned, target));

    }

}
