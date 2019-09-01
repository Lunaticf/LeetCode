package leetCode.tree.convertSortedArrayToBinarySearchTree;


import leetCode.tree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    // 将一个递增数组变成bst, 并返回树根
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    public TreeNode recur(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (right + left) / 2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = recur(nums, left, mid - 1);
        t.right = recur(nums, mid + 1, right);
        return t;
    }


}
