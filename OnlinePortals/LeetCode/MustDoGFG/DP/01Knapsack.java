class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int cap, int wts[], int val[], int n) {
        // S : O(cap) - LINEAR, T: O(n * cap)

        // introduce effect of wts in a top-down manner
        // memoise jaisa hai
        // for each wts[i-1], start j from cap,
        // introduce effect of each wt if possible

        int[] dp = new int[cap + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = cap; j >= 0; j--) {
                if (j - wts[i - 1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - wts[i - 1]] + val[i - 1]);
                }
            }
        }

        // for(int ele : dp){
        //     System.out.print(ele + " ");
        // }
        // System.out.println();

        return dp[cap];
    }
}