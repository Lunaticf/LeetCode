package LeetCode.tree.flattenBinaryTreeToLinkedList;

import LeetCode.tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        // flatten右边
        flatten(root.right);
        // flatten左边
        flatten(root.left);

        // 把flatten之后的左边直接接到右边
        TreeNode rightCopy = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode t = root;
        while (t.right != null) {
            t = t.right;
        }
        t.right = rightCopy;
    }

    // iterative
    // 就是不断地把右子树接到左子树的最右孩子的后面即可
    // 然后每一次其实都会把root的左边变为空，向下一层
    public void flatten1(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode t = root.left;
                while (t.right != null) {
                    t = t.right;
                }
                t.right = root.right;

                // 再把左子树整体挪到右边
                root.right = root.left;
                root.left = null;

            }
            root = root.right;
        }
    }
}
