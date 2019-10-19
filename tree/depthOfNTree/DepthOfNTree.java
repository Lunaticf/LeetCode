package leetCode.tree.depthOfNTree;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/**
 * @Author Lunaticf
 * @Date 2019/10/16
 */
public class DepthOfNTree {
    public int maxDepth(Node root) {
        if (root == null) {return 0;}
        int max = 1;
        for (Node node : root.children) {
            max = Math.max(maxDepth(node) + 1, max);
        }
        return max;
    }

    public int maxDepth1(Node root) {
        if (root == null) {return 0;}
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(maxDepth(node), max);
        }
        return max + 1;
    }
}
