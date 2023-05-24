class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums)
            temp.add(n);
        for (int i = 1; i < k; i++)
            temp.poll();
        return temp.peek();
    }
}