class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int ball = 0; ball < grid[0].length; ball++) {
            int row = 0, col = ball;
            while (row < grid.length) {
                if (grid[row][col] == 1 &&
                    col < grid[0].length - 1 &&
                    grid[row][col + 1] != -1) {
                    row++;
                    col++; 
                } else if (grid[row][col] == -1 &&
                           col > 0 &&
                           grid[row][col - 1] != 1) {
                    row++;
                    col--;
                } else
                    break;    
            }
            result[ball] = row == grid.length ? col : -1;
        }
        return result;
    }
}