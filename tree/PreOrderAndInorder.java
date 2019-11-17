package leetCode.tree;

public class PreOrderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recur(preorder, 0,  inorder, 0, inorder.length - 1);
    }

    private TreeNode recur(int[] preorder, int i, int[] inorder, int p , int q) {
        if (i > preorder.length || p > q) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[i]);
        // 拿root在中序里面找位置
        int k = p;
        for (; k <= q; k++) {
            if (inorder[k] == preorder[i]) {
                break;
            }
        }

        node.left = recur(preorder, i + 1, inorder, p, k - 1);
        // 这里关键是preorder的位置从哪里开始
        node.right = recur(preorder, i + k - p + 1, inorder, k + 1, q);
        return node;

    }
}
