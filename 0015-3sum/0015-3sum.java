class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            
            int l = i + 1, r = nums.length - 1;
            
            while (l < r) {
                int sum = nums[i] + nums[r] + nums[l];
                
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    
                    result.add(temp);
                    l++; r--;
                    
                    while(l < r && nums[l] == nums[l - 1])
                        l++;
                    
                    while(l < r && nums[r] == nums[r + 1])
                        r--;
                } else if (sum < 0)
                    l++;
                else
                    r--;
            }
        }
        
        return result;
    }
}