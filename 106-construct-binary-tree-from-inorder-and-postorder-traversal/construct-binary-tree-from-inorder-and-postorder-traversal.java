import java.util.*;

class Solution {
    int idx;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] in, int[] post) {
        idx = post.length - 1;
        for (int i = 0; i < in.length; i++) map.put(in[i], i);
        return build(post, 0, in.length - 1);
    }

    TreeNode build(int[] post, int l, int r) {
        if (l > r) return null;
        TreeNode root = new TreeNode(post[idx--]);
        int m = map.get(root.val);
        root.right = build(post, m + 1, r);
        root.left = build(post, l, m - 1);
        return root;
    }
}
