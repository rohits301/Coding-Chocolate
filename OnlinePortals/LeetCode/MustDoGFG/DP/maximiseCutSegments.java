class Solution {
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        // Your code here
        // similar to unbounded knapsack

        int[][] dp = new int[4][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp, Integer.MIN_VALUE);
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

            }
        }
    }
}