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
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = nums2.length-1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();
                if(stack.isEmpty()) map.put(nums2[i],-1);
                else map.put(nums2[i],stack.peek());
                stack.push(nums2[i]);
            }

            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
            }
}