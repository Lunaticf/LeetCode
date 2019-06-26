package LeetCode.tree.binaryTreeLevelOrderTraversal;

import LeetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    // bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode t = queue.poll();
                level.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    // dfs
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(res, root, 0);
        return res;
    }

    private void bfs(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;

        if (height >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(height).add(root.val);
        bfs(res, root.left, height + 1);
        bfs(res, root.right, height + 1);
    }
}
