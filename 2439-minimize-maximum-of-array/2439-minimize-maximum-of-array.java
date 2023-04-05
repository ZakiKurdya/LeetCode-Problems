class Solution {
    public int minimizeArrayValue(int[] nums) {
        int result = -1;
        long sumSoFar = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            
            result = Math.max(result, (int) Math.ceil(sumSoFar / (1.0 * (i + 1)))); 
        }
        
        return result;
    }
}