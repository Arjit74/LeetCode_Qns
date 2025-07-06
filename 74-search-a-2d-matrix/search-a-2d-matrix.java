class Solution {
    public boolean searchMatrix(int[][] a, int t) {
        int m = a.length, n = a[0].length;
        int l = 0, r = m * n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = a[mid / n][mid % n];

            if (val == t) return true;
            if (val < t) l = mid + 1;
            else r = mid - 1;
        }

        return false;
    }
}
