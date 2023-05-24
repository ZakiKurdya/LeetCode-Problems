class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++)
            map.put(nums2[i], i);
        
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]), value = -1;
            
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[index]) {
                    value = nums2[j];
                    break;
                }
            }
            
            nums1[i] = value;
        }
        
        return nums1;
    }
}