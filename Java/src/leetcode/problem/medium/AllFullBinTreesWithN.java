package leetcode.problem.medium;

import com.sun.source.tree.Tree;
import leetcode.classes.TreeNode;
import org.junit.Test;

import java.util.*;

/** Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.*/
public class AllFullBinTreesWithN {
    Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> comb = new ArrayList<>();
        if (n%2==0) return comb;
        if (cache.get(n) == null) {
            if (n==1) {
                comb.add(new TreeNode());
            } else {
                for (int left = 1; left < n; left+=2) {
                    int right = n - 1 - left;
                    List<TreeNode> leftTree = allPossibleFBT(left);
                    List<TreeNode> rightTree = allPossibleFBT(right);
                    for (TreeNode leftNode: leftTree) {
                        for (TreeNode rightNode: rightTree) {
                            comb.add(new TreeNode(0, leftNode, rightNode));
                        }
                    }
                }
            }
            cache.put(n, comb);
        }
        return cache.get(n);
    }

    @Test
    public void sampleTest() {
        long startTime = System.currentTimeMillis();
        System.out.println( allPossibleFBT(7));
        System.out.println(System.currentTimeMillis()-startTime + " ms");
    }
}
