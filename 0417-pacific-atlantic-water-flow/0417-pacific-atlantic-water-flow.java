class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] pacificReachable = new boolean[r][c];
        boolean[][] atlanticReachable = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(i == 0 || j == 0)
                    searchAndMark(heights, pacificReachable, i, j);
                if(i == r - 1 || j == c - 1)
                    searchAndMark(heights, atlanticReachable, i, j);
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(pacificReachable[i][j] && atlanticReachable[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    ans.add(tmp);
                }
            }
        }
        
        return ans;
    }
    
    private void searchAndMark(int[][] heights, boolean[][] visited, int i, int j) {
        if(isValid(heights, i, j)) {
            if(visited[i][j])
                return;
            visited[i][j] = true;
            if(isValid(heights, i, j + 1) && heights[i][j] <= heights[i][j + 1])
                searchAndMark(heights, visited, i, j + 1);
            if(isValid(heights, i, j - 1) && heights[i][j] <= heights[i][j - 1])
                searchAndMark(heights, visited, i, j - 1);
            if(isValid(heights, i + 1, j) && heights[i][j]<= heights[i + 1][j])
                searchAndMark(heights, visited, i + 1, j);
            if(isValid(heights, i - 1, j) && heights[i][j]<= heights[i - 1][j])
                searchAndMark(heights, visited, i - 1, j);
        }
    }
    
    private boolean isValid(int[][] heights, int i, int j) {
        if(i < 0 || i > heights.length - 1 || j < 0 || j > heights[0].length - 1)
            return false;
        return true;
    }
}