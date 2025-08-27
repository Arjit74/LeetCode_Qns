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
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base cases:
        // 1. Both are null (empty trees) - they are the same.
        if (p == null && q == null) {
            return true;
        }

        // 2. One is null and the other isn't - they are different.
        if (p == null || q == null) {
            return false;
        }

        // 3. Values are different - they are different.
        if (p.val != q.val) {
            return false;
        }

        // Recursive step:
        // If the current nodes are the same, recursively check if their left and right subtrees are the same.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}