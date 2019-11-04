package leetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
    /**
     * 评论区有个非常规做法 像迭代器一样我觉得也很棒
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 应该只能把每一个的序列先弄出来
        // 中序遍历可以
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getLeaf(root1, list1);
        getLeaf(root2, list2);

        return list1.equals(list2);
    }

    private void getLeaf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        getLeaf(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        getLeaf(root.right, list);
    }
}
