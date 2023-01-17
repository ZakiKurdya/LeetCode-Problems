class Solution {
    public int surfaceArea(int[][] grid) {
        if (grid.length == 1)
            return 2 + grid[0][0] * 4;
        
        // upper and lower surface area
        int area = grid.length * grid[0].length * 2; 
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    area -= 2;
                
                // outer side surface area
                if (i == grid.length - 1 || i == 0 || j == 0 || j == grid[0].length - 1) {
                    if ((i == grid.length - 1 || i == 0) && (j == 0 || j == grid[0].length - 1))
                        area += grid[i][j] * 2;
                    else
                        area += grid[i][j];
                }
                
                // inner side surface area
                if (i < grid.length - 1 && grid[i][j] > grid[i + 1][j]) // down
                    area += grid[i][j] - grid[i + 1][j];
                if (i > 0 && grid[i][j] > grid[i - 1][j]) // up
                    area += grid[i][j] - grid[i - 1][j];
                if (j > 0 && grid[i][j] > grid[i][j - 1]) // left
                    area += grid[i][j] - grid[i][j - 1];
                if (j < grid[0].length - 1 && grid[i][j] > grid[i][j + 1]) // right
                    area += grid[i][j] - grid[i][j + 1];
            }
        }
        return area;
    }
}