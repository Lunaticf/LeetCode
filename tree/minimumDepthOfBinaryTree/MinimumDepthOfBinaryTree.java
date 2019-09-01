package leetCode.tree.minimumDepthOfBinaryTree;

import leetCode.tree.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // this line can be removed, just to be more understandable
        if (root.left == null && root.right == null) return 1;
        // 注意只有到叶子节点才算 空的不能算0
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
