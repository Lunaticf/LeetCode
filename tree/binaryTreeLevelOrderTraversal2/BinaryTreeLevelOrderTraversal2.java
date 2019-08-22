package LeetCode.tree.binaryTreeLevelOrderTraversal2;

import LeetCode.tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {

    // 1. 层次遍历和逆转
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        queue.add(root);

        while (!queue.isEmpty()) {
            // 当前一层元素个数
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
                level.add(t.val);
            }

            res.add(level);
        }

        Collections.reverse(res);
        return res;
    }
}
