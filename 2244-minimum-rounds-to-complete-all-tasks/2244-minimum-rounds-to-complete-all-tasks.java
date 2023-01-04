class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        int rounds = 0;
        for (int value : freq.values()) {
            if (value == 1)
                return -1;

            if (value % 3 == 0)
                rounds += value / 3;
            else
                rounds += value / 3 + 1;
        }
        return rounds;
    }
}