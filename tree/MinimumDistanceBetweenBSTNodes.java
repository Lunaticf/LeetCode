package leetCode.tree;

/**
 * @Author Lunaticf
 * @Date 2019/10/30
 */
public class MinimumDistanceBetweenBSTNodes {
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        // bst有特性啊 遍历有序序列得到最小差值就可以了
        inOrder(root);
        return min;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);

        if (prev == null) {
            prev = node.val;
        } else {
            min = Math.min(min, node.val - prev);
            prev = node.val;
        }

        inOrder(node.right);


    }
}
