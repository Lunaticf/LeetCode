package leetCode.tree.invertBinaryTree;

import leetCode.tree.TreeNode;

import java.util.Stack;

/**
 * @Author Lunaticf
 * @Date 2019/9/12
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        // more concise
        if (root != null) {
            TreeNode temp = root.right;

            root.right = invertTree(root.left);
            root.left = invertTree(temp);
        }
        return root;
    }


    /**
     * 迭代的做法 对每一个节点都交换左右子树
     * 用栈或队列都一样 只是遍历的顺序不同
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode t = s.pop();
            TreeNode temp = t.left;
            t.left = t.right;
            t.right = temp;

            if (t.left != null) {
                s.push(t.left);
            }

            if (t.right!=null) {
                s.push(t.right);
            }

        }
        return root;
    }
}
