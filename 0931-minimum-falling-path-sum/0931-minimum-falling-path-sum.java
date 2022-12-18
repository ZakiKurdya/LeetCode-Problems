class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minOfAbove = matrix[i - 1][j];
                if (j > 0 && matrix[i - 1][j - 1] < minOfAbove)
                    minOfAbove = matrix[i - 1][j - 1];
                if (j + 1 < n && matrix[i - 1][j + 1] < minOfAbove)
                    minOfAbove = matrix[i - 1][j + 1];
                matrix[i][j] += minOfAbove;            
            }
        }
        
        return  Arrays.stream(matrix[n - 1]).min().getAsInt();
    }
}