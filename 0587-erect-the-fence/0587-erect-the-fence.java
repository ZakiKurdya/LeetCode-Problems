class Solution {
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (a, b) -> ((a[0] - b[0] != 0) ? (a[0] - b[0]) : (a[1] - b[1])));
        int n = trees.length;

        boolean[] isUsed = new boolean[n];
        int[] hull = new int[n + 2];
        Arrays.fill(isUsed, false);

        int top = 0;

        for (int i = 0; i < n; i++) {
            
            while (top >= 2 && getArea(trees[hull[top - 1]], trees[hull[top]], trees[i]) > 0) {
                isUsed[hull[top--]] = false;
            }

            hull[++top] = i;
            isUsed[i] = true;
        }

        isUsed[0] = false;
        for (int i = n - 1; i >= 0; i--) {

            if (isUsed[i]) {
                continue;
            }

            while (top >= 2 && getArea(trees[hull[top - 1]], trees[hull[top]], trees[i]) > 0) {
                top--;
            }

            hull[++top] = i;
        }

        top--;

        int[][] treesCoordinates = new int[top][2];
        for (int i = 1; i <= top; i++) {
            treesCoordinates[i - 1][0] = trees[hull[i]][0];
            treesCoordinates[i - 1][1] = trees[hull[i]][1];
        }

        return (treesCoordinates);

    }

    public int getArea(int[] a, int[] b, int[] c) {
        int x1 = b[0] - a[0], y1 = b[1] - a[1];
        int x2 = c[0] - a[0], y2 = c[1] - a[1];
        return (x1 * y2 - x2 * y1);
    }
}