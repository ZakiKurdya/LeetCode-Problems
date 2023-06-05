class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // Traverse the outer boundary and mark all connected 'O's as visited
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, visited);
            
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1, visited);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j, visited);
            
            if (board[m - 1][j] == 'O')
                dfs(board, m - 1, j, visited);
        }

        // Traverse the entire board and capture the surrounded regions
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length, n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != 'O')
            return;

        visited[i][j] = true;

        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i, j - 1, visited);
    }
}
