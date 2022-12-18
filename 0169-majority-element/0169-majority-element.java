class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        boolean isFirst = true;
        int max = -1;
        for (int key : freq.keySet()) {
            if (isFirst) {
                max = key;
                isFirst = false;
            }
            if (freq.get(max) <= freq.get(key))
                max = key;
        }

        return max;
    }
}