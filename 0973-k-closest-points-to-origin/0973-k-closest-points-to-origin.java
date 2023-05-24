class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> Double.compare(euclideanDistance(a[0], a[1]),
                                                     euclideanDistance(b[0], b[1])));
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i][0] = points[i][0];
            result[i][1] = points[i][1];
        }
        
        return result;            
    }
    
    private double euclideanDistance(int x, int y) {
        // between (x, y) and (0, 0)
        return Math.sqrt(x*x + y*y);
    }
}