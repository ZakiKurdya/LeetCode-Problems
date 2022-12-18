class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
            
        long s = nums[0], e = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i + 1] - nums[i] == 1)
                e = nums[i + 1];
            else {
                if (e - s > 0)
                    result.add(s + "->" + e);
                else
                    result.add(String.valueOf(s));
                if (i != nums.length - 1) {
                    s = nums[i + 1];
                    e = s;   
                }
            }    
        }
        
        return result;
    }
}