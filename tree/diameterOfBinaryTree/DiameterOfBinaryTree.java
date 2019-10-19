package leetCode.tree.diameterOfBinaryTree;

import leetCode.tree.TreeNode;

/**
 * @Author Lunaticf
 * @Date 2019/10/15
 */
public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // 其实就是对每个节点求其左右子树深度之和+1
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = depth(root.left);
        int rMax = depth(root.right);

        // 注意是指路径长度 而不是节点个数
        max = Math.max(max, lMax + rMax);
        return Math.max(lMax, rMax) + 1;
    }
}
