class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] temp = new int[m][n];
        
        for (int i = 0; i < indices.length; i++) {
            for (int c = 0; c < n; c++)
                temp[indices[i][0]][c]++;
            
            for (int r = 0; r < m; r++)
                temp[r][indices[i][1]]++;
        }
        
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (temp[i][j] % 2 != 0)
                    sum++;
        }
        
        return sum;
    }
}