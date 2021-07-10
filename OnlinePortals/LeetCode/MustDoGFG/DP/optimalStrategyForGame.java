
class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        int[][] dp = new int[arr.length][arr.length];

        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {

                if (gap == 0) {
                    dp[i][j] = arr[i];
                } else if (gap == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    // (my choice), i -> i + 1, j
                    // (opp.), if i + 1 -> i + 2, j
                    // else j -> i + 1, j - 1
                    int v1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);

                    // (my choice), j -> i, j - 1
                    // (opp.), if i -> i + 1, j - 1
                    // else j - 1 -> i, j - 2
                    int v2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);

                    dp[i][j] = Math.max(v1, v2);
                }
            }
        }

        return dp[0][arr.length - 1];
    }
}