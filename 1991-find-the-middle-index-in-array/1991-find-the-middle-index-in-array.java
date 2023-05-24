class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        
        if (n == 1) return 0;
        
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        
        for (int i = 1; i < n; i++)
            prefixSum[i] = nums[i] +  prefixSum[i - 1];
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (prefixSum[n - 1] - prefixSum[0] == 0)
                    return 0;
            } else if (i == n - 1) {
                if (prefixSum[n - 2] == 0)
                    return n - 1;
            } else {
                if (prefixSum[i - 1] == prefixSum[n - 1] - prefixSum[i])
                    return i;
            }            
        }
        
        return -1;
    }
}