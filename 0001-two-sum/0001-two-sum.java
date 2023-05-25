    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> numbers = new HashMap<>();
            int[] result = new int[0];
            
            for (int i = 0; i < nums.length; i++) {
                if (numbers.containsKey(target - nums[i])) {
                    result = new int[]{numbers.get(target - nums[i]), i};
                    break;
                } else
                    numbers.put(nums[i], i);
            }
            
            return result;
        }
    }