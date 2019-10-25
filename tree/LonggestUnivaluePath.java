package leetCode.tree;

/**
 * @Author Lunaticf
 * @Date 2019/10/25
 */
public class LonggestUnivaluePath {
    /**
     * 最长的单值路径 可以不经过root
     * @param root
     * @return
     */
    private int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        calculate(root);
        return ans;
    }

    /**
     * 返回的是一颗树的单边的最长路径
     * @param root
     * @return
     */
    private int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 站在root上，要想与左节点连接，左节点必须提供单边最长的路径 而不能提供cross的路径长度
        int left = calculate(root.left);
        int right = calculate(root.right);

        if (root.left != null && root.val == root.left.val) {
            left += 1;
        } else {
            left = 0;
        }

        if (root.right != null && root.val == root.right.val) {
            right += 1;
        } else {
            right = 0;
        }

        ans = Math.max(ans, left + right);
        // 只能返回一边的ans
        return Math.max(left, right);
    }
}
