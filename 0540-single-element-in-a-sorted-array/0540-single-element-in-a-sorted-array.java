class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid % 2 != 0)
                mid--;
            if (nums[mid] != nums[mid + 1])
                r = mid;
            else
                l = mid + 2;
        }
        return nums[l];
    }
}