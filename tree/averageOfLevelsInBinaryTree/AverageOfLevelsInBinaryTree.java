package leetCode.tree.averageOfLevelsInBinaryTree;

import leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // level遍历即可
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() != 0) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode t = queue.poll();
                levelSum += t.val;
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            res.add(levelSum / levelSize);
        }
        return res;
    }
}
