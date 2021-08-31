class Solution {
    public int maxSumIS(int arr[], int n) {
        int omax = Integer.MIN_VALUE;

        n = arr.length;
        int[] dp = new int[n]; // stores sum of max inc. subseq.

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) { // strictly increasing
                    if (max == Integer.MIN_VALUE) {
                        max = dp[j]; // first element
                    } else if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            if (max == Integer.MIN_VALUE) {
                dp[i] = arr[i]; // start new subseq.
            } else {
                dp[i] = max + arr[i];
            }

            omax = Math.max(dp[i], omax);
        }

        // for(int val : dp){
        // System.out.print(val + " ");
        // }
        // System.out.println();
        return omax;
    }
}