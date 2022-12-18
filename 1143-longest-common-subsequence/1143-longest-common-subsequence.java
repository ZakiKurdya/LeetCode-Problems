class Solution {
    String s1, s2;
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (text1.charAt(i - 1) != text2.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                else
                    dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }
        return dp[n][m];
        */
        this.s1 = text1;
        this.s2 = text2;
        this.memo = new int[s1.length()][s2.length()];
        return LCS(0, 0);
    }
    
    private int LCS(int i, int j) {
        if (i == s1.length() || j == s2.length())
            return 0;
        
        if (memo[i][j] != 0)
            return memo[i][j];
        
        if (s1.charAt(i) == s2.charAt(j))
            return 1 + LCS(i + 1, j + 1);
        
        int choice1 = LCS(i + 1, j);
        int choice2 = LCS(i, j + 1);
        
        memo[i][j] = Math.max(choice1, choice2);
        return memo[i][j];
    }
}