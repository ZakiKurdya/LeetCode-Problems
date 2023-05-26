class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > sum && sum < 0)
                sum = 0;
            
            sum += nums[i];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}