class Solution {
    private int oldColor;
    private int newColor;
    private boolean visited[][];

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        oldColor = image[sr][sc];
        newColor = color;
        visited = new boolean[image.length][image[0].length];
        helper(image, sr, sc);
        return image;
    }

    private void helper(int[][] image, int x, int y) {
        if (x < 0 || x >= image.length ||
            y < 0 || y >= image[0].length ||
            image[x][y] != oldColor)
            return;

        if (image[x][y] == oldColor)
            image[x][y] = newColor;

        if (visited[x][y])
            return;

        visited[x][y] = true;

        helper(image, x - 1, y);         
        helper(image, x + 1, y);
        helper(image, x, y + 1);
        helper(image, x, y - 1);
    }
}