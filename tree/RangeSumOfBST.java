package leetCode.tree;

import leetCode.linkedList.linkedListCycle.LinkedListCycle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lunaticf
 * @Date 2019/11/7
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }

        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }


    /**
     * 迭代
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST1(TreeNode root, int L, int R) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n.val >= L && n.val <= R) {
                res += n.val;
                queue.offer(n.left);
                queue.offer(n.right);
            }

            if (n.val < L) {
                queue.offer(n.right);
            }
            if (n.val > R) {
                queue.offer(n.left);
            }
        }

        return res;
    }
}
