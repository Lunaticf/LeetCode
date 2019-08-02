package LeetCode.tree.houseRobber3;

import LeetCode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {
    // 自己最初写的
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }


        int left = rob(root.left);
        int right = rob(root.right);

        int ll = 0, lr = 0, rl = 0,rr = 0;
        if (root.left != null) {
            ll = rob(root.left.left);
            lr = rob(root.left.right);
        }
        if (root.right != null) {
            rl = rob(root.right.left);
            rr = rob(root.right.right);
        }
        return Math.max(root.val + ll + lr + rl + rr, left + right);
    }

    // simplify
    public int rob1(TreeNode root) {
        if (root == null) return 0;

        int val = 0;    // 代表选中root节点的计数
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.right) + rob(root.right.left);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    /** clear solution **/
    public int rob2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robInclude(root),robExclude(root));
    }

    // 包括这个节点的情况
    private int robInclude(TreeNode node) {
        if (node == null) return 0;
        return robExclude(node.left) + robExclude(node.right) + node.val;
    }

    private int robExclude(TreeNode node) {
        if (node == null) return 0;
        return rob(node.left) + rob(node.right);
    }

    // 用map记忆化搜索

    public int rob3(TreeNode root) {
        return robRecur(root, new HashMap());
    }

    private int robRecur(TreeNode node, Map map) {
        if (node == null) return 0;
        if (map.containsKey(node)) return (int) map.get(node);

        // 如果没计算过
        int val = 0;    // 代表选中root节点的计数
        if (node.left != null) {
            val += robRecur(node.left.left, map) + robRecur(node.left.right, map);
        }

        if (node.right != null) {
            val += robRecur(node.right.right, map) + robRecur(node.right.left, map);
        }

        int res = Math.max(val + node.val, robRecur(node.left, map) + robRecur(node.right, map));
        map.put(node, res);
        return res;
    }

    // 退一步想 为什么有重叠子问题 因为入口处不知道是不是用了这个节点
    public int rob4(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    // res[0]表示不用这个节点 res[1]表示用
    private int[] robSub(TreeNode node) {
        if (node == null) return new int[2];

        int[] left = robSub(node.left);
        int[] right = robSub(node.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + node.val;

        return res;
    }

}
