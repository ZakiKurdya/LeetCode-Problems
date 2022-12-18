class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] temp = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];
            for (int j = 0; j < n; j++)
                temp[row][j] += 1;
            for (int j = 0; j < m; j++)
                temp[j][col] += 1;
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] % 2 != 0)
                    cnt++;
            }
        }
        
        return cnt;
    }
}