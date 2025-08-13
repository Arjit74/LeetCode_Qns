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
    public int camera = 0;
    
    public int minCameraCover(TreeNode root) {
        int status = minCamera(root);
        if (status == -1) {
            camera++;
        }
        return camera;
    }
    
    public int minCamera(TreeNode node) {
        if (node == null) {
            return 0;  // No camera needed for null nodes
        }
        
        int left = minCamera(node.left);
        int right = minCamera(node.right);
        
        // If any child needs a camera, place camera here
        if (left == -1 || right == -1) {
            camera++;
            return 1;  // This node has a camera now
        }
        
        // If any child has a camera, this node is covered
        if (left == 1 || right == 1) {
            return 0;  // This node is covered by a child's camera
        }
        
        // If no child has camera and not covered, ask parent to place a camera
        return -1;  // This node needs a camera
    }
}