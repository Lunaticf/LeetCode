package LeetCode.tree.pathSum;

import LeetCode.tree.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return recur(root, root.val, sum);
    }

    private boolean recur(TreeNode root, int curSum, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return curSum == sum;
        }

        boolean leftWalk = root.left != null && recur(root.left, curSum + root.left.val, sum);
        boolean rightWalk = root.right != null && recur(root.right, curSum + root.right.val, sum);
        return leftWalk || rightWalk;
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return  hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum- root.val);
    }
}
