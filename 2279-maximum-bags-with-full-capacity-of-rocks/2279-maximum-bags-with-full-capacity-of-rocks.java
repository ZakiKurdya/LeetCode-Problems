class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < rocks.length; i++)
            rocks[i] = capacity[i] - rocks[i];
        Arrays.sort(rocks);
        int count = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] == 0)
                count++;
            else {
                if (rocks[i] <= additionalRocks) {
                    additionalRocks -= rocks[i];
                    count++;
                } else break;
            }
        }
        return count;
    }
}