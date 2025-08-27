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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    // Ensures all nodes in 'root' are in (min.val, max.val)
    private boolean validate(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        if (max != null && root.val >= max.val) return false;
        if (min != null && root.val <= min.val) return false;

        return validate(root.left, min, root) &&
               validate(root.right, root, max);
    }
}