package LeetCode.hashTable.findDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class FindDuplicateSubtrees {

    HashMap<String, Integer> counter = new HashMap<>();
    ArrayList<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        collection(root);
        return res;
    }

    private String collection(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + collection(node.left) + collection(node.right);
        counter.put(serial, counter.getOrDefault(serial, 0) + 1);
        if (counter.get(serial) == 2) res.add(node);
        return serial;
    }
}
