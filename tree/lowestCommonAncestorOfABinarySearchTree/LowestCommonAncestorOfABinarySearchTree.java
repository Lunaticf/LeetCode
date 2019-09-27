package leetCode.tree.lowestCommonAncestorOfABinarySearchTree;

import leetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lunaticf
 * @Date 2019/9/27
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 层次遍历每一个节点 如果他能同时找到p和q 就是祖先 复杂度可能高
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode res = null;

        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if (findChild(node, p) && findChild(node, q)) {
                res = node;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return res;
    }

    // 能否到达dest
    private boolean findChild(TreeNode node, TreeNode dest) {
        if (node == null) {
            return false;
        }
        if (node == dest) {
            return true;
        }

        return findChild(node.left, dest) || findChild(node.right, dest);

    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        return root;
    }


    // 最好的解法 三行 so elegant
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
}
