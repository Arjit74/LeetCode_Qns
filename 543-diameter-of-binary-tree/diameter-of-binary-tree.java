class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).dt;
    }

    public DiaPair diameter(TreeNode root) {
        if (root == null) {
            return new DiaPair();
        }

        // Recursively calculate diameter and height for left and right subtrees
        DiaPair ldp = diameter(root.left); // Left diameter pair
        DiaPair rdp = diameter(root.right); // Right diameter pair

        // Self diameter (sum of left height and right height + 2)
        int sd = ldp.ht + rdp.ht + 2;

        // Create current diameter pair
        DiaPair sdp = new DiaPair();
        sdp.dt = Math.max(sd, Math.max(ldp.dt, rdp.dt)); // Max of self, left, and right diameters
        sdp.ht = Math.max(ldp.ht, rdp.ht) + 1; // Height is max of left/right height + 1

        return sdp;
    }

    // Helper class to store diameter and height
    class DiaPair {
        int dt = 0; // Diameter
        int ht = -1; // Height
    }
}