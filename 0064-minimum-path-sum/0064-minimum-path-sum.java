class Solution {
    private int[][] memo;
    
    public int minPathSum(int[][] grid) {    
        int m = grid.length - 1, n = grid[0].length - 1;
        
        memo = new int[m + 1][n + 1];
        
        return helper(grid, m, n);
    }
        
    private int helper(int grid[][], int m, int n) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return grid[0][0];
        else if (memo[m][n] != 0)
            return memo[m][n];
        else
            return memo[m][n] = grid[m][n] + 
                   Math.min(helper(grid, m - 1, n), helper(grid, m, n - 1)); 
   }
}