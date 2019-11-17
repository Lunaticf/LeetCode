package leetCode.tree;

import leetCode.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        // 转化为平衡的BST
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return convert(list, 0, list.size() - 1);
    }

    private TreeNode convert(List<Integer> list, int i, int j) {
        if (i > j) {
            return null;
        }

        // 找到中间节点
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = convert(list, i, mid - 1);
        root.right = convert(list, mid + 1, j);
        return root;
    }
}
