class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(
            helper(nums1, nums2),
            helper(nums2, nums1)
        );
    }
    
    private List<Integer> helper(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(); 
        Set<Integer> set2 = new HashSet<>(); 
        
        for (int num : nums2)
            set2.add(num);
        
        for (int num : nums1)
            if (!set2.contains(num))
                set1.add(num);
        
        return new ArrayList<>(set1);
    }
}