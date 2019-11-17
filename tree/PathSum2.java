package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 找到和等于sum的path

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root, sum, 0, res, temp);
        return res;
    }

    private void dfs(TreeNode root, int sum, int cur, List<List<Integer>> res,List<Integer> temp) {


        if (root == null) {
            return;
        }

        cur += root.val;
        temp.add(root.val);

        if (root.left == null && root.right == null && cur == sum) {
            res.add(new ArrayList<>(temp));
        } else {
            dfs(root.left, sum, cur, res, temp);
            dfs(root.right, sum, cur, res, temp);
        }


        // dfs(root.left, sum, cur, res, new ArrayList<>(temp));
        // dfs(root.right, sum, cur, res, new ArrayList<>(temp));

        // 省点空间

        temp.remove(temp.size() - 1);

    }
}
