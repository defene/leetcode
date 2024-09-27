class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curGas = 0;
        int totalGas = 0;
        int result = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];

            if (curGas < 0) {
                result = i + 1;
                curGas = 0;
            }
        }

        return totalGas >= 0 ? result : -1;
    }
}