package leetCode.tree.twoSumBST;

import leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        // 在一颗BST中找两个元素和等于k
        // 又要利用BST的性质

        List<Integer> sequence = new ArrayList<>();
        dfs(root, sequence);
        int i = 0, j = sequence.size() - 1;
        while (i < j) {
            int sum = sequence.get(i) + sequence.get(j);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                i++;
            }
            if (sum > k) {
                j--;
            }
        }
        return false;
    }

    public void dfs(TreeNode node, List<Integer> sequence) {
        if (node == null) {
            return;
        }

        dfs(node.left, sequence);
        sequence.add(node.val);
        dfs(node.right, sequence);
    }

    /**
     * hashMap
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget1(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(set, root, k);
    }

    private boolean helper(HashSet<Integer> set, TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);
        return helper(set, root.left, k) || helper(set, root.right, k);
    }

    /**
     * binary search 100%....？
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget2(TreeNode root, int k) {
        return dfs1(root, root, k);
    }

    private boolean dfs1(TreeNode root, TreeNode cur, int k) {
        if (cur == null) {
            return false;
        }

        // 二分搜索
        TreeNode t = root;
        int target = k - cur.val;
        while (t != null) {
            if (t.val == target && t != cur) {
                return true;
            } else if (t.val > target) {
                t = t.left;
            } else {
                t = t.right;
            }
        }

        return dfs1(root, cur.left, k) || dfs1(root, cur.right, k);
    }



}
