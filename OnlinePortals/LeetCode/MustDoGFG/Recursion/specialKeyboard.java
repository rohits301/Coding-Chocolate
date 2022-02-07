class Solution {
    // T: O(n^2), S : O(n)
    static int optimalKeys(int N) {
        // code here

        if (N <= 6) {
            return N;
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= N; i++) {
            for (int j = i - 3; j >= 1; j--) {

                int val = dp[j] * (i - j - 1);

                if (val > dp[i])
                    dp[i] = val;
            }
        }
        return dp[N];
    }
}