package leetCode.tree;

/**
 * @Author Lunaticf
 * @Date 2019/10/25
 */
public class BinaryTreeMaximumPathSum {
    int ans = Integer.MIN_VALUE;

    // 最大的一条路径和 不必须经过root
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calculate(root);
        return ans;
    }

    private int calculate(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = calculate(node.left);
        int right = calculate(node.right);

        int cur = node.val;

        if (left > 0) {
            cur += left;
        }

        if (right > 0) {
            cur += right;
        }

        ans = Math.max(ans, cur);
        return Math.max(node.val,Math.max(left + node.val, right + node.val));


//        ans = multipleMax(ans, left + right + node.val, node.val, node.val + left, node.val + right);
//        return multipleMax(left, right, 0) + node.val;
    }

//    private int multipleMax(int... nums) {
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            max = Math.max(max, nums[i]);
//        }
//        return max;
//    }
}
