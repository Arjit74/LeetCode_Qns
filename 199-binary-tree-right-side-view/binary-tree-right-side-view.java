import java.util.ArrayList;
import java.util.List;

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
public class Solution {
    private int maxDepth = -1; // Track the maximum depth visited

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, result); // Start at depth 0
        return result;
    }

    private void rightView(TreeNode node, int depth, List<Integer> result) {
        if (node == null) { 
            return;
        }

        // If visiting a new depth for the first time, add the node value
        if (depth > maxDepth) {
            result.add(node.val);
            maxDepth = depth;
        }

        // Traverse the right subtree first, then the left subtree
        rightView(node.right, depth + 1, result);
        rightView(node.left, depth + 1, result);
    }
}