class Solution {
    // T: O(n^2), S: O(n)
    public int maxHeight(int[][] cuboids) {
        // Similar to Box stacking but easier

        int n = cuboids.length;

        // 1. sort the 1d arrays
        for (int[] ar : cuboids) {
            Arrays.sort(ar);
        }

        // 2. sort the 2d array column-wise in desc. order
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if (a1[0] != a2[0])
                    return a2[0] - a1[0];
                if (a1[1] != a2[1])
                    return a2[1] - a1[1];
                return a2[2] - a1[2];
            }
        });

        // 3. LDS - Longest Decreasing Subsequence on height
        int[] dp = new int[n];
        int omax = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2]; // current height

            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] <= cuboids[j][0] && 
                    cuboids[i][1] <= cuboids[j][1] && 
                    cuboids[i][2] <= cuboids[j][2]) {

                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }

            omax = Math.max(dp[i], omax);
        }
        
        // for(int[] ar: cuboids){
        //     for(int val : ar){
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }

        return omax;
    }
}