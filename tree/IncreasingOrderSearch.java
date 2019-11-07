package leetCode.tree;

/**
 * @Author Lunaticf
 * @Date 2019/11/6
 */
public class IncreasingOrderSearch {
    TreeNode res;
    TreeNode prev;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 第一个节点
        if (res == null) {
            res = node;
        } else {
            prev.right = node;
        }

        node.left = null;
        prev = node;

        inorder(node.right);
    }
}
