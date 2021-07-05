class Solution {

    public int minCoins(int coins[], int M, int V) {
        // Your code goes here
        int amt = V;

        int[] dp = new int[amt + 1];
        Arrays.fill(dp, amt + 1); // fill array with a big number, to calculate min

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int val = coins[j];
                // i => target, val => coin available

                if (i - val >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - val]); // +1 for using the coin
                }
            }
        }
        // if not possible to pay
        if (dp[amt] == amt + 1) {
            return -1;
        }

        return dp[amt];
    }
}