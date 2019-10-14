package leetCode.tree.findModeInBST;

import leetCode.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/10/14
 */
public class FindModeInBst {

    private int maxCount;
    private Integer prev;
    private int count;


    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        maxCount = 0;
        count = 1;

        // 要利用BST的特性 中序遍历是一个递增的序列
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        // 左中右
        inorder(root.left, res);

        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
                prev = root.val;
            }
        } else {
            prev = root.val;
        }

        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(root.val);
        } else if (count == maxCount) {
            res.add(root.val);
        }

        inorder(root.right, res);
    }
}
