class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int start = i+1;
            int end = nums.length-1;
            
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    int first = nums[start];
                    int last = nums[end];
                    while(start<end && nums[start]==first) start++;
                    while(start<end && nums[end]==last) end--;
                }
                else if(sum<0){
                    start++;
                }
                else{
                    end--;
                }
            }
            while(i+1<nums.length && nums[i]==nums[i+1]) i++;
            
        }
        
        return result;
    }
}