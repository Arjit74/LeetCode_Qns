class Solution {
    int res = 0;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        back(0, n, col, d1, d2);
        return res;
    }

    void back(int r, int n, boolean[] col, boolean[] d1, boolean[] d2) {
        if (r == n) {
            res++;
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col[c] || d1[r + c] || d2[r - c + n]) continue;
            col[c] = d1[r + c] = d2[r - c + n] = true;
            back(r + 1, n, col, d1, d2);
            col[c] = d1[r + c] = d2[r - c + n] = false;
        }
    }
}
