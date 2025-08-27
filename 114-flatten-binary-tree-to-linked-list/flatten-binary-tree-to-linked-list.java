

class Solution {
    public TreeNode flattenHelper(TreeNode root, TreeNode prev) {
        // base case
        if (root == null)
            return prev;
        TreeNode right = flattenHelper(root.right, prev);
	
        TreeNode left = flattenHelper(root.left, right);
        
        root.right = left;
        root.left = null;
        
        return root;
    }
    
    public void flatten(TreeNode root) {
        flattenHelper(root, null);
    }
}