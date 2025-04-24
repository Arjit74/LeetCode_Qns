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
    public boolean isBalanced(TreeNode root) {
        return check(root)!=-1;
    }
    private int check(TreeNode root){
        if(root==null) return 0;

        int leftdepth=check(root.left);
        if(leftdepth==-1) return -1;
        int rightdepth=check(root.right);
        if(rightdepth==-1) return -1;

        if(Math.abs(leftdepth-rightdepth)>1) return -1;
        return Math.max(leftdepth,rightdepth)+1;
    }
}

