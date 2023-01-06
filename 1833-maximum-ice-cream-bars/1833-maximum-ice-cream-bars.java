class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int counter = 0;
        for (int item : costs) {
            if (item <= coins) {
                coins -= item;
                counter++;
            } else break;
        }
        return counter;
    }
}