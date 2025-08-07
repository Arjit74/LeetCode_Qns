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
    public class Info {
        int min;
        int max;
        boolean isBST;
        int sum;

        Info(int min, int max, boolean isBST, int sum) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.sum = sum;
        }
    }

    private int maxSum;

    public Info helper(TreeNode root) {
        if(root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }
        Info leftInfo = helper(root.left);
        Info rightInfo = helper(root.right);

        int sum = leftInfo.sum + rightInfo.sum + root.val;
        int min = Math.min(root.val, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.val, Math.max(leftInfo.max, rightInfo.max));

        if(root.val >= rightInfo.min || root.val <= leftInfo.max) {
            return new Info(min, max, false, sum);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxSum = Math.max(maxSum, sum);
            return new Info(min, max, true, sum);
        }

        return new Info(min, max, false, sum);
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
}