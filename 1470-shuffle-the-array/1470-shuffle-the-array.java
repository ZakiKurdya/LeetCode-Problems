class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int f = 0, s = n; 
        for (int i = 0; i <= nums.length - 2; i += 2) {
            result[i] = nums[f++];
            result[i + 1] = nums[s++];
        }
        return result;
    }
}