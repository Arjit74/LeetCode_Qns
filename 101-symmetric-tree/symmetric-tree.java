class Solution {
    public boolean isMirror(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        
        // both nodes are null -> they are symmetric
        if(root1!=null && root2!=null){
            if(root1.val!=root2.val) return false;
        }
        // one is null and the other is not -> trees are not symmetric
        else if(root1==null && root2!=null){
            return false;
        }else if(root1!=null && root2==null){
            return false;
        }

        // check:
        boolean left = isMirror(root1.left, root2.right);  // left subtree of root1 with right subtree of root2
        boolean right = isMirror(root1.right, root2.left);  // right subtree of root1 with left subtree of root2

        return left && right;
    } 
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
}