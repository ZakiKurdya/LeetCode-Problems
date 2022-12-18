class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    try {
                        if (grid[i - 1][j] != 1)
                            perimeter++;
                    } catch (IndexOutOfBoundsException ex) {
                        perimeter++;
                    }

                    try {
                        if (grid[i + 1][j] != 1)
                            perimeter++;
                    } catch (IndexOutOfBoundsException ex) {
                        perimeter++;
                    }

                    try {
                        if (grid[i][j - 1] != 1)
                            perimeter++;
                    } catch (IndexOutOfBoundsException ex) {
                        perimeter++;
                    }

                    try {
                        if (grid[i][j + 1] != 1)
                            perimeter++;
                    } catch (IndexOutOfBoundsException ex) {
                        perimeter++;
                    }
                }
            }
        }
        
        return perimeter;
    }
}