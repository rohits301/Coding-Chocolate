class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int cap, int wts[], int val[], int n) {
        // your code here
        n = wts.length;
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j - wts[i - 1] >= 0) { // can Play
                    dp[i][j] = Math.max(dp[i - 1][j - wts[i - 1]] + val[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][cap];
    }
}