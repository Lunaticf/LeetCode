package leetCode.tree.nTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NTreeLevelOrderTraversal {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {

            List<Integer> list = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            res.add(list);

        }
        return res;

    }
}
