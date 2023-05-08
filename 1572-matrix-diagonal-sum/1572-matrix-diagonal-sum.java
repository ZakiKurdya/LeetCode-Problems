class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i] + mat[i][mat.length - 1 - i];
            if (mat.length % 2 != 0 && i == (mat.length - 1) / 2)
                sum -= mat[i][i];
        }
        
        return sum;
    }
}