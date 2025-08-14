/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int left = q.peek().idx;
            int right = left;
            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                right = current.idx;               
                if (current.node.left != null) {
                    q.add(new Pair(current.node.left, 2 * current.idx));
                }
                if (current.node.right != null) {
                    q.add(new Pair(current.node.right, 2 * current.idx + 1));
                }
            }   
            maxWidth = Math.max(maxWidth, right - left + 1);
        }   
        return maxWidth;
    }
    class Pair {
        TreeNode node;
        int idx;       
        public Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
}