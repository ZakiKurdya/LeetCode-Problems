class Solution {
    int[][] memo;
    int max = Integer.MIN_VALUE;
    
    public int findLength(int[] nums1, int[] nums2) {
        memo = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);
        
        find(0, 0, nums1, nums2);
        return max;
    }
    
    private int find(int i, int j, int[] n1, int[] n2) {
        if (memo[i][j] != -1)
            return memo[i][j];
        
        if (i == n1.length || j == n2.length)
            return memo[i][j] = 0;
        
        int len = 0;
        
        if (n1[i] == n2[j])
            len = 1 + find(i + 1, j + 1, n1, n2);
        
        max = Math.max(max, len);
        
        find(i + 1, j, n1, n2);
        find(i, j + 1, n1, n2);
        
        return memo[i][j] = len;
    }
}