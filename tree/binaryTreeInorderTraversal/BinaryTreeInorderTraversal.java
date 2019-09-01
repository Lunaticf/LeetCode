package leetCode.tree.binaryTreeInorderTraversal;

import leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        recur(root);
        return res;
    }
    private void recur(TreeNode t) {
        if (t == null) return;
        if (t.left != null) recur(t.left);
        res.add(t.val);
        if (t.right != null) recur(t.right);
    }

    // iteration
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
