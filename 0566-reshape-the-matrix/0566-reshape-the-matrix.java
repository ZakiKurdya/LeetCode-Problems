class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c)
            return mat;
            
        int[][] reshaped = new int[r][c];
        int or = 0, oc = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (oc == mat[0].length) {
                    or++;
                    oc = 0;
                }
                reshaped[i][j] = mat[or][oc];
                oc ++;
            }
        }
        return reshaped;
    }
}