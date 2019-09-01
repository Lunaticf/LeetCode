package leetCode.recursion.uniqueBinarySearchTrees2;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return genTreesHelper(1, n);
    }

    // 递归函数
    private List<TreeNode> genTreesHelper(int left, int right) {
        List<TreeNode> res = new ArrayList<>();

        if (left > right) {
            res.add(null);
            return res;
        }

        // 每次以i为root
        for (int i = left; i <= right; i++) {
            // 得到左边所有元素可能组成的root
            List<TreeNode> leftRoots = genTreesHelper(left, i - 1);
            // 得到右边所有元素可能组成的root
            List<TreeNode> rightRoots = genTreesHelper(i + 1, right);


            for (TreeNode leftRoot : leftRoots) {
                for (TreeNode rightRoot : rightRoots) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);
                }
            }

        }

        return res;

    }

}
