
class Solution {
    static int equalPartition(int N, int arr[]) {
        // code here
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }

        if (sum % 2 != 0) {
            return 0; // no
        }

        boolean ans = isSubsetSum(arr, sum / 2);
        return ans == true ? 1 : 0;
    }

    static boolean isSubsetSum(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) { // empty arr
                    dp[i][j] = false;
                } else if (j == 0) { // sum = 0, all elements can make it
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    int val = arr[i - 1];

                    if (j - val >= 0) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - val];
                    }
                }
            }
        }
        return dp[arr.length][sum];
    }
}