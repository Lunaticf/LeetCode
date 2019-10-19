package leetCode.tree.mergeTwoBinaryTrees;

import leetCode.tree.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null) {
            return t2;
        }

        if (t2 != null) {
            t1.val += t2.val;
        }

        if (t2 == null) {
            return t1;
        }

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
