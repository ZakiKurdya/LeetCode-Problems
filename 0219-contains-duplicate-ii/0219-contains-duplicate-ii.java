class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // (put) returns the previous value associated with the key, or null
            Integer index = map.put(nums[i], i);
            
            if (index != null && i - index <= k)
                return true;
        }
        
        return false;
    }
}