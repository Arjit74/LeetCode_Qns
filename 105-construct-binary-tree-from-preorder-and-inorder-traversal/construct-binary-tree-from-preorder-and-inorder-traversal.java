import java.util.*;

class Solution {
    int idx = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) map.put(in[i], i);
        return build(pre, 0, in.length - 1);
    }

    TreeNode build(int[] pre, int l, int r) {
        if (l > r) return null;
        TreeNode root = new TreeNode(pre[idx++]);
        int m = map.get(root.val);
        root.left = build(pre, l, m - 1);
        root.right = build(pre, m + 1, r);
        return root;
    }
}
