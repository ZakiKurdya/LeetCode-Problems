class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue pq = new PriorityQueue();
        for (int num : nums) {
            pq.add(num);
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = (int) pq.poll();
        }
        
        return result;
    }
}