package leetCode.tree.trimBST;

import leetCode.tree.TreeNode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        // 修剪子树的时候注意
        // 如果子树的根节点都被修剪了，子树的左子树或者右子树必然有一颗也将修剪
        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }


        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
