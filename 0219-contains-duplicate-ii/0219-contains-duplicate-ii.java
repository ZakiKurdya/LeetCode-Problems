class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            
            if (map.containsKey(temp) && Math.abs(map.get(temp) - i) <= k)
                return true;
            else
                map.put(temp, i);
        }
        
        return false;
    }
}