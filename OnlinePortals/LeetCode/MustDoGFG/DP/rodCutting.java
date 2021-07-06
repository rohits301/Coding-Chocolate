class Solution{
    public int cutRod(int price[], int n) {
        //code here
        
        int[] dp = new int[n + 1];
        
        for(int i = 1; i < dp.length; i++){
            dp[i] = price[i - 1]; // dp[i] maps to prices[i - 1]
            int max = 0;
            
            for(int j = 1; j <= i; j++){
                max = Math.max(max, price[j - 1] + dp[i - j]);
            }
            dp[i] = max;
        }
        
        return dp[n];
    }
}