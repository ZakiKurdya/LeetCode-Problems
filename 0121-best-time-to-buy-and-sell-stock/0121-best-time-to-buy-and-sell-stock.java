class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = -1;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            
            int profit = prices[i] - min;
            max = Math.max(max, profit);
        }
        
        return max;
    }
}