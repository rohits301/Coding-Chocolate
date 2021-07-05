class Solution {

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // code here
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true; // sum = 0, arr = empty
                } else if (i == 0) {
                    dp[i][j] = false; // arr = empty
                } else if (j == 0) {
                    dp[i][j] = true; // sum = 0, alw. true, use empty subset
                } else {
                    dp[i][j] = dp[i - 1][j]; // rest of the team can score 'j' runs
                    int val = arr[i - 1];

                    if (j - val >= 0) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - val];
                        // 'i' is included
                        // then rest of the team has to score 'j - val' runs
                    }
                }
            }
        }
        return dp[arr.length][sum];
    }
}