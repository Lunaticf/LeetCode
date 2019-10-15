package leetCode.tree.minimumAbsoluteDiffInBST;

import leetCode.tree.TreeNode;

/**
 * @Author Lunaticf
 * @Date 2019/10/15
 */
public class MinimumAbsoluteDiffInBST {
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        // 得到任意两个节点之间的最小差
        // 注意是BST
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);

        if (prev != null) {
            min = Math.min(node.val - prev, min);

        }
        prev = node.val;

        inOrder(node.right);
    }
}
