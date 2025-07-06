class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] dp = new int[m][n];
        
        if (g[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) dp[i][0] = (g[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        for (int j = 1; j < n; j++) dp[0][j] = (g[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (g[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
