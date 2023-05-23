class KthLargest {
    private final PriorityQueue<Integer> numsPQ = new PriorityQueue<>();
    private final int k;

    public KthLargest(int k, int[] nums) {
        for (int num : nums)
            numsPQ.add(num);
        this.k = k;
    }

    public int add(int val) {
        numsPQ.add(val);
        while(numsPQ.size()>k)
            numsPQ.poll();
        return numsPQ.element();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */