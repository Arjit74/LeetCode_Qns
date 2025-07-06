class Solution {
    public TreeNode sortedArrayToBST(int[] a) {
        return build(a, 0, a.length - 1);
    }

    TreeNode build(int[] a, int l, int r) {
        if (l > r) return null;
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(a[m]);
        root.left = build(a, l, m - 1);
        root.right = build(a, m + 1, r);
        return root;
    }
}
