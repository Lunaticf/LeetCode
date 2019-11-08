package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] x1 = walk(root, x, 0);
        int[] y1 = walk(root, y, 0);

        if (root.val == x || root.val == y) {
            return false;
        }

        if (x1[0] != y1[0] && x1[1] == y1[1]) {
            return true;
        }

        return false;
    }

    private int[] walk(TreeNode root, int x, int depth) {
        if (root == null) {
            return null;
        }

        if (root.left != null && root.left.val == x) {
            return new int[]{root.val, depth};
        }

        if (root.right != null && root.right.val == x) {
            return new int[]{root.val, depth};
        }

        int[] res1 = walk(root.left, x, depth + 1);
        int[] res2 = walk(root.right, x, depth + 1);

        return res1 == null?res2:res1;
    }


    /**
     * 迭代100%啦
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins1(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        if (root.val == x || root.val == y) {
            return false;
        }

        int level = 0;
        int xParent = -1, yParent = -1;
        int xLevel = -1, yLevel = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.left.val == x) {
                        xParent = node.val;xLevel = level;
                    }
                    if (node.left.val == y) {
                        yParent = node.val;yLevel = level;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x) {
                        xParent = node.val;xLevel = level;
                    }
                    if (node.right.val == y) {
                        yParent = node.val;yLevel = level;
                    }
                    queue.offer(node.right);
                }

            }

            level++;
        }

        return xParent != yParent && xLevel == yLevel;
    }
}
