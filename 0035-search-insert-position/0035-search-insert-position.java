class Solution {
    public int searchInsert(int[] nums, int target) {
        int insertionPoint = Arrays.binarySearch(nums, target);
        return insertionPoint >= 0 ? insertionPoint : -1 * (insertionPoint + 1);
    }
}