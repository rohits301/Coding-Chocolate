class Solution {
    // T: O(n), S: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        int sumGas = 0;
        int sumCost = 0;

        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += gas[i] - cost[i]; // prefix sum of gas[i]-cost[i]

            if (temp < minVal) {
                minIdx = i;
                minVal = temp;
            }

            sumGas += gas[i];
            sumCost += cost[i];
        }

        if (sumGas - sumCost < 0) {
            return -1; // no solution
        }

        if (minIdx == n - 1) {
            return 0;
        } else {
            return minIdx + 1;
        }
    }
}