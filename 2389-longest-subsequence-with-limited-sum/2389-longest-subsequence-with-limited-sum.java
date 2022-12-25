class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        // sort nums array
        Arrays.sort(nums);
        // accumulate (prefix sum)
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        
        // binary search
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int insertion = Arrays.binarySearch(nums, queries[i]);
            if (insertion < 0)
                result[i] = (insertion + 2) * -1 + 1;
            else
                result[i] = insertion + 1;
        }
        
        return result;
    }
}