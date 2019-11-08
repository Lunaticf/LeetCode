package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class UnivalueTree {
    public boolean isUnivalTree(TreeNode root) {
        // univalued的意思是每个节点有相同的值
        // 这也太简单了
        if (root == null) return true;
        boolean left = true;
        if (root.left != null) {
            left = (root.val == root.left.val) && isUnivalTree(root.left);
        }
        boolean right = true;
        if (root.right != null) {
            right = (root.val == root.right.val) && isUnivalTree(root.right);
        }
        return left && right;
    }

    /**
     * 来个迭代
     * @param root
     * @return
     */
    private Integer prev;
    public boolean isUnivalTree1(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() != 0) {
            TreeNode node = queue.poll();

            if (prev == null) {
                prev = node.val;
            } else {
                if (node.val != prev) {
                    return false;
                }
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return true;
    }
}
