class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1] + Math.min(dp[0], dp[1]);
        for(int i = 2; i < dp.length; i++) {
            if(i == cost.length) {
                dp[i] = 0;
            } else {
                dp[i] = cost[i];
            }
            dp[i] += Math.min(dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}