class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, curGas = 0, startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                startIndex = i + 1;
                curGas = 0;
            }
        }
        return totalGas >= 0 ? startIndex : -1;
    }
}