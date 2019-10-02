package leetCode.tree.sumOfLeftLeaves;

import leetCode.tree.TreeNode;

/**
 * @Author Lunaticf
 * @Date 2019/9/30
 */
public class SumOfLeftLeaves {
    /**
     * 找所有在左边的叶子节点的和 递归定义
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) return 0;

        // 先拿左孩子
        TreeNode leftNode = root.left;
        // 如果左孩子不为空
        if (leftNode != null) {
            // 如果左孩子是叶子节点 直接加上val
            if (leftNode.left == null && leftNode.right == null) {
                return leftNode.val + sumOfLeftLeaves(root.right);
            } else {
                // 不是叶子节点 继续遍历
                return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            }
        } else {
            // 左孩子是空 去递归右孩子
            return sumOfLeftLeaves(root.right);
        }

    }

    // 简洁点的写法
    public int sumOfLeftLeaves1(TreeNode root) {

        if (root == null) return 0;

        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        return res + sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }
}
