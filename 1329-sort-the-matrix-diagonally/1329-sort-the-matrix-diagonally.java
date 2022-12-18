class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int n = mat.length, m = mat[0].length;
        int[][] result = new int[n][m];
       
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map.containsKey(i - j))
                    map.get(i - j).add(mat[i][j]);
                else {
                    PriorityQueue<Integer> temp = new PriorityQueue<>();
                    temp.add(mat[i][j]);
                    map.put((i - j), temp);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result[i][j] = map.get(i - j).poll();
            }
        }
                
        return result;
    }
}