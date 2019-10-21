package leetCode.tree.secondMinimumNode;

import leetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lunaticf
 * @Date 2019/10/21
 */
public class SecondMinimumNode {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        // root.val = min(root.left.val, root.right.val)
        // 这颗二叉树比较独特
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Integer res = null;
        while (queue.size() != 0) {
            TreeNode node = queue.poll();

            if (node.val > root.val) {
                if (res == null) {
                    res = node.val;
                } else {
                    res = Math.min(node.val, res);
                }
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return res == null ? -1 : res;
    }


    public int findSecondMinimumValue1(TreeNode root) {
        // 每棵树只有0个或2个孩子...
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int leftVal = root.left.val;
        // 如果相等
        if (root.val == leftVal) {
            leftVal = findSecondMinimumValue(root.left);
        }

        int rightVal = root.right.val;
        // 如果相等
        if (root.val == rightVal) {
            rightVal = findSecondMinimumValue(root.right);
        }

        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        } else if (leftVal == -1) {
            return rightVal;
        } else {
            return leftVal;
        }

    }
}
