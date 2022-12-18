class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++)
            for (int j = 0; j < img[0].length; j++)
                result[i][j] = filter(img, i, j);
        return result;           
    }

    private int filter(int[][] img, int i, int j) {
        int result = img[i][j]; // center
        int count = 1;

        // first row
        if (i - 1 >= 0) {
            result += img[i - 1][j];
            count++;
            if (j - 1 >= 0) {
                result += img[i - 1][j - 1];
                count++;
            }
            if (j + 1 < img[0].length) {
                result += img[i - 1][j + 1];
                count++;
            }
        }

        // second row except center
        if (j - 1 >= 0) {
            result += img[i][j - 1];
            count++;
        }
        if (j + 1 < img[0].length) {
            result += img[i][j + 1];
            count++;
        }    

        // third row
        if (i + 1 < img.length) {
            result += img[i + 1][j];
            count++;
            if (j - 1 >= 0) {
                result += img[i + 1][j - 1];
                count++;
            }
            if (j + 1 < img[0].length) {
                result += img[i + 1][j + 1];
                count++;
            }
        }

        return result / count;
    }
}