class Solution {
// 99% solution    
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < nums2.length; i++)
//             map.put(nums2[i], i);
        
//         for (int i = 0; i < nums1.length; i++) {
//             int index = map.get(nums1[i]), value = -1;
            
//             for (int j = index + 1; j < nums2.length; j++) {
//                 if (nums2[j] > nums2[index]) {
//                     value = nums2[j];
//                     break;
//                 }
//             }
            
//             nums1[i] = value;
//         }
        
//         return nums1;
//     }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            map.put(nums1[i], i);
        
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        
        int[] result = new int[nums1.length];
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int temp = stack.pop();
                if (map.containsKey(temp) == true)
                    result[map.get(temp)] = nums2[i];
            }
            
            if (map.containsKey(nums2[i]))
                stack.push(nums2[i]);
        }
                
        while (!stack.isEmpty())
            result[map.get(stack.pop())] = -1;
        
        return result;
    }
}