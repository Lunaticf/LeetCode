package leetCode.tree.convertBstToGreaterTree;

import leetCode.tree.TreeNode;

/**
 * @Author Lunaticf
 * @Date 2019/10/15
 */
public class ConvertBstToGreaterTree {
    private Integer prev = null;
    // 这里可以直接设为0也可

    public TreeNode convertBST(TreeNode root) {
        // 很明显应该从后往前倒着加
        helper(root);
        return root;
    }

    public void helper(TreeNode node) {
        if (node == null) return;
        helper(node.right);
        if (prev != null) {
            node.val += prev;
        }
        prev = node.val;
        helper(node.left);
    }

    /**
     * 不使用全局变量
     * @param root
     * @return
     */
    public TreeNode convertBST1(TreeNode root) {

        helper1(root, 0);
        return root;
    }


    // 这个函数return的是一棵树最左边的子节点的累加值
    private int helper1(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        int rsum = helper1(node.right, sum);
        node.val += rsum;
        return helper1(node.left, node.val);
    }
}
