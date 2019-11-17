package leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> bst = new ArrayList<>();
        inorder(root, bst);

        for (int i = 1; i < bst.size(); i++) {
            if (bst.get(i) <= bst.get(i - 1)) {
                return false;
            }
        }
        return true;
    }


    private void inorder(TreeNode node, List<Integer> bst) {
        if (node == null) {
            return;
        }

        inorder(node.left, bst);
        bst.add(node.val);
        inorder(node.right, bst);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        Integer prev = null;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (prev != null && root.val <= prev) return false;
            prev = root.val;
            root = root.right;
        }

        return true;
    }
}
