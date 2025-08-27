/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Node prev = null, curr = null;
        while(!q.isEmpty()) {
            Node node = q.remove();
            if(node == null) {
                prev = null;
                if(q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                curr = node;
                if(prev != null) {
                    prev.next = curr;
                }
                if(node.left != null)
                q.add(node.left);
                if(node.right != null)
                q.add(node.right);
                prev = curr;
            }
        }
        return root;
    }
}