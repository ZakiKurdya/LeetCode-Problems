class Solution {
    public int findMinArrowShots(int[][] points) {
        // sort points by the x-start
        Arrays.sort(points, (a, b) ->  Integer.compare(a[0], b[0]));
        int arrows = 1;
        for (int row = 0; row < points.length - 1; row++) {
            // there's an intersection
            if (points[row][1] >= points[row + 1][0]) {
                points[row + 1][0] = Math.max(points[row + 1][0], points[row][0]);
                points[row + 1][1] = Math.min(points[row + 1][1], points[row][1]);
            } else
                arrows++;
        }
        return arrows;
    }
}