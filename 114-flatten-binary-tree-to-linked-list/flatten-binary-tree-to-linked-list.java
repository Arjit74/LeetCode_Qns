class Solution {
    public void flatten(TreeNode root) {
        makeLL(root);
    }
    
    private TreeNode makeLL(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null && root.right == null) {
            return root;
        }
        
        TreeNode leftTail = makeLL(root.left);
        TreeNode rightTail = makeLL(root.right);
        
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        // Return the rightmost non-null tail
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return root;
    }
}