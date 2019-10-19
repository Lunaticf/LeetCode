package leetCode.tree.constructStringFromBinaryTree;

import leetCode.tree.TreeNode;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String res = "" + t.val;
        if (t.left != null) {
            res += "(" + tree2str(t.left) + ")";
        }
        if (t.left == null && t.right != null) {
            res += "()";
        }
        if (t.right != null) {
            res += "(" + tree2str(t.right) + ")";
        }
        return res;
    }
}
