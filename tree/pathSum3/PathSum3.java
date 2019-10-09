package leetCode.tree.pathSum3;

import leetCode.tree.TreeNode;

import java.util.HashMap;
import java.util.Locale;

public class PathSum3 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        // key为到当前节点为止的存在的前缀和，value为有多少条路到达这个前缀和（前提都是这一条路径下）
        HashMap<Integer, Integer> map = new HashMap<>();
        // 用于count
        map.put(0, 1);
        return helper(root, sum, 0,  map);
    }

    private int helper(TreeNode node, int sum, int cur, HashMap<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        cur += node.val;

        int res = map.getOrDefault(cur - sum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);

        res += helper(node.left, sum, cur, map) + helper(node.right, sum, cur, map);
        // 执行完这个helper后 不停地回溯 是要把该节点得到的sum在map中去除的
        map.put(cur, map.get(cur) - 1);
        return res;
    }



    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 从这个节点开始的count +
        return walkFromNode(root, sum, 0) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }


    private int walkFromNode(TreeNode node, int sum, int cur) {
        if (node == null) {
            return 0;
        }
        cur += node.val;
//        if (cur == sum) {
//            return 1 + walkFromNode(node.left, sum, cur) + walkFromNode(node.right, sum, cur);
//        }
//        return walkFromNode(node.left, sum, cur) + walkFromNode(node.right, sum, cur);
        return (cur == sum ? 1 : 0) + walkFromNode(node.left, sum, cur) + walkFromNode(node.right, sum, cur);
    }

    // 减着来也可
    public int pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum1(root.left, sum) + pathSum1(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

}
