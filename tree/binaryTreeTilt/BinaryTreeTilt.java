package leetCode.tree.binaryTreeTilt;

import leetCode.tree.TreeNode;

/**
 * @Author Lunaticf
 * @Date 2019/10/16
 */
public class BinaryTreeTilt {
    private int res = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    // 求树的和
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = dfs(node.left);
        int rightSum= dfs(node.right);
        res += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}
