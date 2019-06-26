package LeetCode.tree.binaryTreePreorderTraversal;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    // recursion
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        recur(root);
        return res;
    }

    private void recur(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        if (root.left != null) recur(root.left);
        if (root.right != null) recur(root.right);
    }

    // iteration
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                res.add(t.val);
                if (t.right != null) stack.push(t.right);
                if (t.left != null) stack.push(t.left);
            }
        }
        return res;
    }
}
