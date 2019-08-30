package LeetCode.tree.balancedBinaryTree;

import LeetCode.tree.TreeNode;

public class BalancedBinaryTree {
    // O(NLogN)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 ;
    }

    private int getHeight(TreeNode t) {
        if (t == null) return 0;
        return Math.max(getHeight(t.left), getHeight(t.right)) + 1;
    }


    private static final int UNBALANCED = -99;
    // O(N)
    public boolean isBalanced1(TreeNode root) {
        return helper(root) != UNBALANCED;
    }

    private int helper(TreeNode t) {
        if (t == null) return 0;

        int left = helper(t.left);
        int right = helper(t.right);

        if (left != UNBALANCED && right != UNBALANCED && Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        }
        return UNBALANCED;
    }

}
