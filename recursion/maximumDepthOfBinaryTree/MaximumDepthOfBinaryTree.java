package leetCode.recursion.maximumDepthOfBinaryTree;



import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }


     public int maxDepth(TreeNode root) {
         if (root == null) return 0;
         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     }

     // itertion
     public int maxDepth1(TreeNode root) {
         if (root == null) return 0;

         Deque<TreeNode> deque = new LinkedList<>();

         int count = 0;
         deque.offer(root);


         while(!deque.isEmpty()) {
             int size = deque.size();
             while (size-- > 0) {
                 TreeNode cur = deque.poll();
                 if (cur.left != null) {
                     deque.offer(cur.left);
                 }
                 if (cur.right != null) {
                     deque.offer(cur.right);
                 }
             }
             count++;
         }

         return count;
     }


     // dfs version
     public int maxDepth2(TreeNode root) {
         if (root == null) return 0;

         Stack<TreeNode> stack = new Stack<>();
         // 存放节点的深度
         Stack<Integer> depthRecorder = new Stack<>();

         stack.push(root);
         depthRecorder.push(1);

         int res = 0;

         while (!stack.isEmpty()) {
             int curDepth = depthRecorder.pop();
             TreeNode curNode = stack.pop();

             res = Math.max(curDepth, res);

             if (curNode.left != null) {
                 stack.push(curNode.left);
                 depthRecorder.push(curDepth + 1);
             }

             if (curNode.right != null) {
                 stack.push(curNode.right);
                 depthRecorder.push(curDepth + 1);
             }
         }

         return res;
     }

}
