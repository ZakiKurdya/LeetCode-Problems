class Solution {
    public int countNegatives(int[][] grid) {
        int counter = 0, cols = grid[0].length;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] < 0) {
                    counter += cols - j;
                    break;
                }
            }
        }
        
        return counter;
    }
}