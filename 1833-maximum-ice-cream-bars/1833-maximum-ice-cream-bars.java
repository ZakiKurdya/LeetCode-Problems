class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int counter = 0, sum = 0;
        for (int item : costs) {
            sum += item;
            if (sum <= coins)
                counter++;
            else break;
        }
        return counter;
    }
}