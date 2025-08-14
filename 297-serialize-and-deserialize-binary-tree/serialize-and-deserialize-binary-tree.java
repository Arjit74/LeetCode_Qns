/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }
    
    private void build(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        build(node.left, sb);
        build(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] nodes = data.split(",");
        return buildTree(nodes, new int[]{0});
    }
    
    private TreeNode buildTree(String[] nodes, int[] index) {
        if (index[0] >= nodes.length || nodes[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]++]));
        node.left = buildTree(nodes, index);
        node.right = buildTree(nodes, index);
        return node;
    }
}