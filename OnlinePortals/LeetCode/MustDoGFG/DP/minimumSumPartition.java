class Solution {

	public int minDifference(int arr[], int n) { 
	    // Your code goes here
        
        // dp ka i => arr ka (i - 1) (Mapping)
        // a combo. of subset sum problem (targetSumSubsets)
        // and partition equal subset sum (equi partition array)
        
        //1. TSS
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                } else if(i == 0){
                    dp[i][j] = false; // arr size = 0
                } else if(j == 0){
                    dp[i][j] = true; // sum = 0
                } else {
                    // excluding me rest can achieve sum
                    dp[i][j] = dp[i - 1][j]; 
                    
                    int val = arr[i - 1];
                    
                    if(j - val >= 0){ // can be included
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - val];
                    }
                }
            }
        }
        
        // 2. range waala khel
        int minDiff = Integer.MAX_VALUE;
        for(int j = 0; j <= sum / 2; j++){
            if(dp[n][j] == true){
                minDiff = Math.min(minDiff, sum - 2 * j);
            }
        }
        
        return minDiff;
	} 
}