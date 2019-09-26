package leetCode.tree.binaryTreePaths;

import leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/9/26
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            dfs(res, root, "");
        }
        return res;
    }


    private void dfs(List<String> res, TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            res.add(s + root.val);
        }

        if (root.left != null) {
            dfs(res, root.left, s +  root.val + "->");
        }
        if (root.right != null) {
            dfs(res, root.right, s +  root.val + "->");
        }
    }
}
