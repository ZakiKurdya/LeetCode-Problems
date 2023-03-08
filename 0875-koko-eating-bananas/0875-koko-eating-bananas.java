class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MIN_VALUE;
        
        for (int i = 0; i < piles.length; i++)
            right = Math.max(right, piles[i]);
        
        int k = Integer.MAX_VALUE;
        
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            
            int temp = 0;
            for (int pile : piles)
                temp += Math.ceil(pile * 1.0 / mid);
            
            if (temp <= h) {
                k = Math.min(k, mid);
                
                right = mid - 1;
            } else
                left = mid + 1;
        }
        
        return k;
    }
}