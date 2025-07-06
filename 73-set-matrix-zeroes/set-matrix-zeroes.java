class Solution {
    public void setZeroes(int[][] a) {
        int m = a.length, n = a[0].length;
        boolean row0 = false, col0 = false;

        for (int i = 0; i < m; i++) if (a[i][0] == 0) col0 = true;
        for (int j = 0; j < n; j++) if (a[0][j] == 0) row0 = true;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 0) {
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][0] == 0 || a[0][j] == 0) a[i][j] = 0;
            }
        }

        if (col0) for (int i = 0; i < m; i++) a[i][0] = 0;
        if (row0) for (int j = 0; j < n; j++) a[0][j] = 0;
    }
}
